package com.example.springbatchdemo.domain;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<InputItem> reader() {
        return new BatchItemReader();
    }

    @Bean
    public ItemProcessor<InputItem, OutputItem> processor(){
        return new BatchItemProcessor();
    }

    @Bean
    public ItemWriter<OutputItem> writer(){
        return new BatchItemWriter();
    }

    @Bean
    public Step step1(){
        return this.stepBuilderFactory
                //step1はステップの名前　※重複しなければなんでもいい
                //chunkを10件単位でコミットしていく
                .get("step1").<InputItem, OutputItem>chunk(10)
                .reader((reader()))
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job runJob() {
        //runJobも重複しなければなんでもいい
        return this.jobBuilderFactory.get("runJob").start(step1()).build();
    }

}
