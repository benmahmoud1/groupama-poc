package com.poc.springbatch.batch.config;

import com.poc.springbatch.batch.listner.FileLoggingListener;
import com.poc.springbatch.batch.listner.FileProcessorFailureListener;
import com.poc.springbatch.batch.listner.FileReaderListner;
import com.poc.springbatch.batch.listner.FileSkipListener;
import com.poc.springbatch.batch.processor.FileProcessor;
import com.poc.springbatch.batch.reader.FileLine;
import com.poc.springbatch.batch.reader.MultiFileReader;
import com.poc.springbatch.batch.tasklet.FileVerificationSkipper;
import com.poc.springbatch.batch.writer.FileWriter;
import com.poc.springbatch.model.TFluxBrutFmntFixe;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.retry.policy.NeverRetryPolicy;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class FileProcessStepConfig {

    private final MultiFileReader reader;
    private final FileProcessor processor;
    private final FileWriter writer;
    private final FileLoggingListener loggingListener;
    private final FileReaderListner fileReaderListner;
    private final FileSkipListener fileSkipListener;
    private final FileProcessorFailureListener fileProcessorFailureListener;
    private final FileVerificationSkipper fileVerificationSkipper;

    /**
     * l'étape d'import du fichier
     *
     * @return Step l'étape construite à partir des reader, processor et writer
     */
    @Bean(name = "fileProcessingStep")
    @Primary
    public Step fileProcessingStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("fileProcessingStep",jobRepository)
                .<FileLine, TFluxBrutFmntFixe>chunk(10,transactionManager)
                .reader(reader)
                .listener(fileReaderListner)
                .faultTolerant()
                .skipPolicy(fileVerificationSkipper)
                .retryPolicy(new NeverRetryPolicy())
                .listener(fileSkipListener)
                .processor(processor)
                .faultTolerant()
                .retryPolicy(new NeverRetryPolicy())
                .listener(fileProcessorFailureListener)
                .writer(writer)
                .faultTolerant()
                .retryPolicy(new NeverRetryPolicy())
                .listener(loggingListener)
                .build();
    }
}
