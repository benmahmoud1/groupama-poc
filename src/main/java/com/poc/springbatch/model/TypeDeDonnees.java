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
@Table(name = "t_type_de_donnees")
public class TypeDeDonnees {

    @Id
    @Column(name = "code_type", length = 1)
    private String codeType;

    @Column(name = "desc_type", columnDefinition = "TEXT")
    private String descType;

}
