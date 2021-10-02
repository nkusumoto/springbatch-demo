package com.example.springbatchdemo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;

public class JobListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(JobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! TIME to verify the results");
        }

    }
}
