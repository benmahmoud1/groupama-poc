package com.poc.springbatch.batch.listner;

import com.poc.springbatch.batch.reader.FileLine;
import com.poc.springbatch.model.TFluxBrutFmntFixe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileProcessorFailureListener implements ItemProcessListener<FileLine, TFluxBrutFmntFixe> {

    public void beforeProcess(TFluxBrutFmntFixe item) {
        //aucun traitement
    }

    @Override
    public void afterProcess(FileLine item, TFluxBrutFmntFixe result) {
        //aucun traitement
    }

    @Override
    public void onProcessError(FileLine item, Exception exception) {
        log.error("Error lors du traitement de l'item [{}]", item, exception);
    }
}

