package com.poc.springbatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JobFormatUniqueController {
    @Autowired
    @Qualifier("formatUniqueJob")
    private Job formatUniqueJob;
    @Autowired
    private JobLauncher jobLauncher;

    @GetMapping("/loadFormatUnique")
    public ResponseEntity productLoad(){
        try{
            var parameters = new JobParametersBuilder().addLong("Start-At" ,System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(formatUniqueJob,parameters);
            return ResponseEntity.ok("job formatUniqueJob terminé avec succès !");

        }catch (Exception e){
            return new ResponseEntity("job formatUniqueJob  en erreur : " + e.getLocalizedMessage(), HttpStatus.EXPECTATION_FAILED);
        }



    }
 }
