package com.poc.springbatch.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JobFluxBrutFmntFixeController {


    @Autowired
    @Qualifier("fileProcessingJob")
    private Job fileProcessingJob;
    @Autowired
    private JobLauncher jobLauncher;

    @PostMapping("/insert")
    public ResponseEntity insertFluxBrutFmntFixe(){
        try{
            var parameters = new JobParametersBuilder().addLong("Start-At" ,System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(fileProcessingJob,parameters);
            return ResponseEntity.ok("job fileProcessingJob terminé avec succès !");

        }catch (Exception e){
            return new ResponseEntity("job fileProcessingJob en erreur : " + e.getLocalizedMessage(), HttpStatus.EXPECTATION_FAILED);
        }

    }

}
