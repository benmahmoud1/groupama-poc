package com.poc.springbatch.batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.Resource;

public class CustomFlatFileItemReader<T> extends FlatFileItemReader<T> {

    private Resource currentResource;

    @Override
    public void setResource(Resource resource) {
        this.currentResource = resource;
        super.setResource(resource);
    }

    public Resource getCurrentResource() {
        return currentResource;
    }
}
