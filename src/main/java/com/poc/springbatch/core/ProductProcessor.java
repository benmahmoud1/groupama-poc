package com.poc.springbatch.core;

import com.poc.springbatch.entity.Product;
import org.springframework.batch.item.ItemProcessor;


public class ProductProcessor implements ItemProcessor<Product,Product> {
    @Override
    public Product process(Product item) throws Exception {
        if(item.getPrice() > 20000){
            return item;
        }
        return null;
    }
}
