package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_code_garantie")
public class CodeGarantie {

    @Id
    @Column(name = "code_garantie_rivage", length = 30)
    private String codeGarantieRivage;


    @Column(name = "code_bo", length = 90, nullable = false)
    private String codeBo;


    @Column(name = "tarif", length = 90, nullable = false)
    private String tarif;


    @Column(name = "categorie", length = 90, nullable = false)
    private String categorie;

    @Column(name = "code_produit", length = 90)
    private String codeProduit;

    @Column(name = "garantie_std", length = 255)
    private String garantieStd;

    @ManyToOne
    @JoinColumn(name = "code_bo", referencedColumnName = "code_bo", insertable = false, updatable = false)
    private BackOffice backOffice;

}
