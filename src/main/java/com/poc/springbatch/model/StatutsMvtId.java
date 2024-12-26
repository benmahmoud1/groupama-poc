package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StatutsMvtId {

    @Column(name = "code_statut", length = 90)
    private String codeStatut;

    @Column(name = "code_bo", length = 90)
    private String codeBo;
}
