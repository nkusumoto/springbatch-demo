package com.example.springbatchdemo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepListener implements StepExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(StepListener.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        //Stepを実行する前に実行する処理を書く
    }

    @Override
    public ExitStatus afterStep (StepExecution stepExecution){
        //Stepを実行した後に実行する処理を書く
        return ExitStatus.COMPLETED;
    }

}
