package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static com.poc.springbatch.misc.Queries.SEL_REGLE_VALO;

@Data  @NoArgsConstructor @AllArgsConstructor @ToString
public class CartoOrdonnancementValorisation {
    private String fluxMaitre;
    private Integer numOrdre;
    private String codeCasPrinc;
    private String codeCasSecond;
    private String actif;
}
