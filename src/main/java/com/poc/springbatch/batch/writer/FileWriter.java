package com.poc.springbatch.batch.writer;

import com.poc.springbatch.model.TFluxBrutFmntFixe;
import com.poc.springbatch.repository.TFluxBrutFmntFixeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class FileWriter implements ItemWriter<TFluxBrutFmntFixe> {

    private final TFluxBrutFmntFixeRepository tFluxBrutFmntFixeRepository;
    @Override
    public void write(Chunk<? extends TFluxBrutFmntFixe> items) throws Exception {

        List<TFluxBrutFmntFixe> tFluxBrutFmntFixes = new ArrayList<>(items.getItems());

        tFluxBrutFmntFixeRepository.saveAll(tFluxBrutFmntFixes);

    }
}
