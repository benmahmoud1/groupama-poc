package com.poc.springbatch.batch.reader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DefaultFieldSet;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MultiFileReader  extends MultiResourceItemReader<FileLine> {

    private int fileNumber = 0;

    public MultiFileReader() {
        CustomFlatFileItemReader<FileLine> delegate = new CustomFlatFileItemReader<>();
        AtomicInteger lineCounter = new AtomicInteger(0);
        delegate.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new CustomPassThroughLineTokenizer());
            setFieldSetMapper(fieldSet -> new FileLine(
                    fieldSet.readRawString(1),
                    determineFileType(delegate.getCurrentResource()),
                    fileNumber,
                    lineCounter.incrementAndGet()
            ));
        }});

        this.setDelegate(delegate);
    }

    @Override
    public void setResources(Resource[] resources) {
        fileNumber = 0; // Reset file number for each job run
        for (Resource resource : resources) {
            try {
                long sizeInKb = resource.getFile().length() / 1024;
                log.info("File {}: {} ({} KB)", ++fileNumber, resource.getFilename(), sizeInKb);
            } catch (IOException e) {
                log.error("Error reading file size for: {}", resource.getFilename(), e);
            }
        }
        super.setResources(resources);
    }

    private String determineFileType(Resource resource) {
        String filename = resource.getFilename();
        if (filename != null && filename.matches("RBO_BCO03_CRE_Admin.*")) {
            return "CRE-ADMIN";
        } else if (filename != null && filename.matches("RBO_CPT01_GPV_AlimXRDJ.*")) {
            return "CRE-COMPTA";
        }
        throw new IllegalArgumentException("Unknown file type for resource: " + resource);
    }

    public static class CustomPassThroughLineTokenizer implements LineTokenizer {
        @Override
        public FieldSet tokenize(String line) {
            return new DefaultFieldSet(new String[]{line});
        }
    }
}
