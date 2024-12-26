package com.poc.springbatch.config;

import com.poc.springbatch.core.FormatUniqueProcessorFromFlatFile;
import com.poc.springbatch.core.TaskLetFormatUnique;
import com.poc.springbatch.model.FormatUnique;
import com.poc.springbatch.repository.IFormatUniqueRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@Repository
public class FormatUniqueBatchConfig {
    @Value("${input.datafile}")
    private String flatDataSource;
    @Autowired
    private IFormatUniqueRepository formatUniqueRepository;

    //item reader
    @Bean

    public FlatFileItemReader<FormatUnique> formatUniqueFlatReaderItemReader() {
        return new FlatFileItemReaderBuilder<FormatUnique>().name("formatUniqueItemReader")
                .resource(new ClassPathResource(flatDataSource))
                .linesToSkip(1)
                .delimited().delimiter(";").strict(false)
                .names("id_trt", "num_ligne", "id_flx_src", "num_ligne_src", "orig_flx", "cdlot", "no_lot", "dat_acte", "dat_creat_mvt", "dat_eff_mvt", "cd_mvt", "ctr_no_maj", "ctr_no_origin", "ctr_cd_tarif", "ctr_categ", "ctr_version_tarif_categ", "ctr_duree_mois", "ctr_duree_annee", "ctr_duree_paiemnt_mois", "ctr_dat_eff", "ctr_dern_prime_payee", "ctr_nb_primes_payees", "ctr_no_propo", "ctr_cd_nature_sortie", "ass_id_grc", "ass_nom", "ass_nom_jeune_fille", "ass_prenom", "ass_age_a_sourcr", "ass_date_naiss", "prod_matricule", "prod_cle_matricule", "prod_cd_geo_ctr_ou_prod", "mnt_id_aia_prime", "mnt_pp_ttc", "mnt_pp_ht", "mnt_dat_eff_prime", "mnt_tx_frais_pp", "mnt_respect_preco_pp", "mnt_pp_ttc_prec", "mnt_pp_ht_prec", "mnt_montant_vl", "mnt_dat_eff_vl", "mnt_frais_vl", "mnt_respect_preco_vl", "mnt_type_vers", "mnt_formule_gestion", "gar_dc_exo_reversion", "gar_dat_eff", "gar_dat_fin", "gar_motif_principal_avenant", "dt_cre", "dt_upd", "statut")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(FormatUnique.class);
                }})
                .build();
    }

    //processor
    @Bean
    public FormatUniqueProcessorFromFlatFile createFormatUniqueProcessorFromFlatFile() {
        return new FormatUniqueProcessorFromFlatFile();
    }

    //writer
    @Bean
    public RepositoryItemWriter<FormatUnique> formatUniqueFromFlatFileFileWriter() {
        RepositoryItemWriter<FormatUnique> repositoryItemWriter = new RepositoryItemWriter<>();
        repositoryItemWriter.setRepository(formatUniqueRepository);
        repositoryItemWriter.setMethodName("save");
        return repositoryItemWriter;
    }
    //step
    @Bean
    public Step stepFormatUnique(JobRepository jobRepository , PlatformTransactionManager transactionManage) {
        return new StepBuilder("stepFormatUniqueFlatFile", jobRepository)
                .<FormatUnique, FormatUnique>chunk(10 , transactionManage)
                .reader(formatUniqueFlatReaderItemReader())
                .processor(createFormatUniqueProcessorFromFlatFile())
                .writer(formatUniqueFromFlatFileFileWriter())
                .build();
    }
    //step 2 use a tasklet
    @Bean
    public Tasklet taskLetFormatUnique(){
        return new TaskLetFormatUnique();
    }

    @Bean
    public Step stepFormatUniqueTest(JobRepository jobRepository , PlatformTransactionManager transactionManage) {
        return new StepBuilder("stepFormatUniqueTest", jobRepository)
                .tasklet(taskLetFormatUnique(), transactionManage)
                .build();
    }

    //job
    @Bean
    public Job formatUniqueJob(JobRepository jobRepository ,
                          @Qualifier("stepFormatUnique") Step step1 ,
                          @Qualifier("stepFormatUniqueTest") Step step2) {
        return new JobBuilder("formatUniqueJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .next(step2)
                .build();
    }

}
