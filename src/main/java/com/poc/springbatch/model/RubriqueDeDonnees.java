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
@Table(name = "t_rubriques_de_donnees")
public class RubriqueDeDonnees {

    @Id
    @Column(name = "code_rubrique", length = 90)
    private String codeRubrique;

    @Enumerated(EnumType.STRING)
    @Column(name = "code_type", length = 1)
    private CodeType codeType;

    @Column(name = "seperateur", length = 30)
    private String seperateur;

    @Column(name = "desc_rubrique", length = 500)
    private String descRubrique;

    @Column(name = "valeur_rubrique", columnDefinition = "TEXT")
    private String valeurRubrique;

  /*  @ManyToOne
    @JoinColumn(name = "code_type", referencedColumnName = "code_type", insertable = false, updatable = false)
    private TypeDeDonnees typeDeDonnees;*/


}