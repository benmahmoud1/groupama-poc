package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "t_code_produit_rivage")
public class CodeProduitRivage {

    @Id
    @Column(name = "code_produit", nullable = false, length = 90)
    private String codeProduit;

    @Column(name = "tarif", length = 90)
    private String tarif;

    @Column(name = "categorie", length = 90)
    private String categorie;

    @Column(name = "version", length = 50)
    private String version;

    @Column(name = "domaine", length = 50)
    private String domaine;


}
