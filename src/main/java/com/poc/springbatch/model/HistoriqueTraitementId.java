package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class HistoriqueTraitementId {


    @Column(name = "id_trt")
    private Integer idTrt;

    @Column(name = "nom_attribut_format_unique", length = 90)
    private String nomAttributFormatUnique;

    @Column(name = "num_ligne")
    private Integer numLigne;
}
