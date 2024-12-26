package com.poc.springbatch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data  @NoArgsConstructor @AllArgsConstructor @ToString
public class ReglesValorisation {
    private String fluxMaitre;
    private String codeCas;
    private Integer noSequence;
    private String nomChampFormatUnique;
    private Integer noCritere;
    private String obligatoire;
    private String valeurParDefaut;
    private String conditionValo;
    private String conditionValoTechnique;
    private String expressionValeur;
    private String expressionValeurTechnique;
    private String codeRegle;
    private String codeMessage;
    private String texteInfoMessage;
    private String texteErreurMessage;
}
