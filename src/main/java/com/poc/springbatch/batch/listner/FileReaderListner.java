package com.poc.springbatch.batch.listner;

import com.poc.springbatch.batch.reader.FileLine;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Getter
@Component
public class FileReaderListner implements ItemReadListener<FileLine> {


    private final Set<Integer> errorReadOffset = new HashSet<>();

    @Override
    public void beforeRead() {
        //aucun traitement
    }

    @Override
    public void afterRead(FileLine fileLine) {
        //aucun traitement
    }

    @Override
    public void onReadError(Exception ex) {
        if (ex instanceof FlatFileParseException flatFileParseException) {
            errorReadOffset.add(flatFileParseException.getLineNumber());
        }
        log.error("Erreur de lecture", ex);
    }

}
