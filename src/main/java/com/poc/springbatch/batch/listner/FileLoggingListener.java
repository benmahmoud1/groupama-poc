package com.poc.springbatch.batch.listner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.Instant;

@Component
@Slf4j
public class FileLoggingListener extends StepExecutionListenerSupport {

    private long startTime;

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        long duration = Instant.now().toEpochMilli() - this.startTime;
        log.info("Durée de traitement : " + duration + " ms");
        return stepExecution.getExitStatus();
    }
}