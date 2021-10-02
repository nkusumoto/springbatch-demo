package com.example.springbatchdemo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class BatchItemWriter implements ItemWriter<OutputItem> {

    private static final Logger log = LoggerFactory.getLogger(BatchItemWriter.class);

    @Override
    public void write(List<? extends OutputItem> items) throws Exception{
        log.info("called write method");
        //本当はここでデータをDBやファイルへ出力する
        log.info("Output("+items+")");
    }

}
