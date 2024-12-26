package com.poc.springbatch.batch.listner;

import com.poc.springbatch.batch.reader.FileLine;
import com.poc.springbatch.model.TFluxBrutFmntFixe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Cette classe permet de tracer seulement les lignes SKIPPED (les cas où on leve une exception)
 * Exemple pour le cas d'une ligne vide
 */
@Slf4j
@Getter
@Component

public class FileSkipListener implements SkipListener<FileLine, TFluxBrutFmntFixe> {

    private final Set<Integer> skippableOffset = new HashSet<>();

    @Override
    public void onSkipInRead(Throwable t) {
        //aucun traitement
    }

    @Override
    public void onSkipInWrite(TFluxBrutFmntFixe item, Throwable t) {
        //aucun traitement
    }

    /**
     * Tracer tous les cas de skipped item "aucun contrôle sur le type de l'exception"
     *
     * @param item the failed item
     * @param t    the cause of the failure
     */
    @Override
    public void onSkipInProcess(FileLine item, Throwable t) {
        skippableOffset.add(item.getLineNumber());
        log.warn("Skipped line  {}", item.getLine());

    }
}
