package com.poc.springbatch.batch.config;

import com.poc.springbatch.batch.listner.JobImportListener;
import com.poc.springbatch.batch.reader.MultiFileReader;
import com.poc.springbatch.batch.tasklet.FileVerificationSkipper;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.ExitCodeMapper;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJvmExitCodeMapper;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

import java.util.Arrays;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {


    @Value("classpath:input/RBO_BCO03_CRE_Admin.*")
    private Resource[] adminFiles;

    @Value("classpath:input/RBO_CPT01_GPV_AlimXRDJ.*")
    private Resource[] comptaFiles;

    @Bean
    public Job fileProcessingJob(JobRepository jobRepository, @Qualifier("fileProcessingStep") Step step, JobImportListener jobImportListener) {
        return new JobBuilder("fileProcessingJob",jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(jobImportListener)
                .start(step)
                .build();
    }

    @Bean
    public MultiFileReader multiFileReader() {
        MultiFileReader reader = new MultiFileReader();
        reader.setResources(concatResources(adminFiles, comptaFiles));
        return reader;
    }

    private Resource[] concatResources(Resource[]... resourceArrays) {
        return Arrays.stream(resourceArrays).flatMap(Arrays::stream).toArray(Resource[]::new);
    }

    @Bean
    public FileVerificationSkipper fileVerificationSkipper() {
        return new FileVerificationSkipper();
    }

    @Bean
    public ExitCodeMapper exitCodeMapper() {
        return new SimpleJvmExitCodeMapper();
    }
}
