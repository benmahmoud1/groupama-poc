package com.poc.springbatch.config;


import com.poc.springbatch.core.ProductProcessor;
import com.poc.springbatch.core.TaskLetProduct;
import com.poc.springbatch.entity.Product;
import com.poc.springbatch.repository.ProductRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration

public class CsvBatchConfig {
    @Value("${file.input}")
    private String source;
    @Autowired
    private ProductRepository productRepository;


    //item reader
    @Bean
    public FlatFileItemReader<Product> productItemReader() {
        return new FlatFileItemReaderBuilder<Product>().name("productItemReader")
                .resource(new ClassPathResource(source))
                .linesToSkip(1)
                .delimited()
                .names(new String[]{"id", "name", "price"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Product.class);
                }})
                .build();
    }

    //processor
    @Bean
    public ProductProcessor createItemProcessor() {

        return new ProductProcessor();
    }

    //writer

    @Bean
    public RepositoryItemWriter<Product> productWriter() {
        RepositoryItemWriter<Product> repositoryItemWriter = new RepositoryItemWriter<>();
        repositoryItemWriter.setRepository(productRepository);
        repositoryItemWriter.setMethodName("save");
        return repositoryItemWriter;
    }

    //step
    @Bean
    public Step stepProduct(JobRepository jobRepository , PlatformTransactionManager transactionManage) {
        return new StepBuilder("stepProduct", jobRepository)
                .<Product, Product>chunk(10 , transactionManage)
                .reader(productItemReader())
                .processor(createItemProcessor())
                .writer(productWriter())
                .build();
    }
    //step 2 use a tasklet
    @Bean
    public Tasklet taskLetProduct(){
        return new TaskLetProduct();
    }
    @Bean
    public Step stepTest(JobRepository jobRepository , PlatformTransactionManager transactionManage) {
        return new StepBuilder("stepTest", jobRepository)
                .tasklet(taskLetProduct(), transactionManage)
                .build();
    }

    //job
    @Bean
    public Job productJob(JobRepository jobRepository ,
                          @Qualifier("stepProduct") Step step1 ,
                          @Qualifier("stepTest") Step step2) {
        return new JobBuilder("productJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .next(step2)
                .build();
    }
}
