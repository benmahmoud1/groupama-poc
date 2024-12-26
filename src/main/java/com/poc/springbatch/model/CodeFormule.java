package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "t_code_formule")
@IdClass(CodeFormuleId.class)
public class CodeFormule {

    @Id
    @Column(name = "code_gt_aia", nullable = false, length = 90)
    private String codeGtAia;

    @Id
    @Column(name = "code_formule", nullable = false, length = 50)
    private String codeFormule;

    @Id
    @Column(name = "code_produit", nullable = false, length = 90)
    private String codeProduit;


}
