package com.poc.springbatch.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
// clé composé

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CodeFormuleId implements Serializable {
    private String codeGtAia;
    private String codeFormule;
    private String codeProduit;

}
