package com.poc.springbatch.core;

import com.poc.springbatch.entity.Product;
import com.poc.springbatch.model.FormatUnique;
import org.springframework.batch.item.ItemProcessor;

public class FormatUniqueProcessorFromFlatFile  implements ItemProcessor<FormatUnique,FormatUnique> {
    @Override
    public FormatUnique process(FormatUnique item) throws Exception {
        return item;
    }
}
