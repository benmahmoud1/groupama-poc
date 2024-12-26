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
public class TypesMvtId {


    @Column(name = "code_type_mvt", length = 30)
    private String codeTypeMvt;


    @Column(name = "code_bo", length = 90)
    private String codeBo;


    @Column(name = "flux_specifique", length = 90, columnDefinition = "varchar(90) default '*'")
    private String fluxSpecifique;
}
