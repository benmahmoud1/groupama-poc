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
@Table(name = "t_types_mvt")
public class TypesMvt {

    @EmbeddedId
    private TypesMvtId typesMvtId;

    @Column(name = "lib_type_mvt", length = 255)
    private String libTypeMvt;

    @Column(name = "desc_type_mvt", length = 255)
    private String descTypeMvt;

    @Column(name = "actif", columnDefinition = "enum('O', 'N') default 'O'", nullable = false)
    private String actif;

    @ManyToOne
    @JoinColumn(name = "code_bo", referencedColumnName = "code_bo", insertable = false, updatable = false)
    private BackOffice backOffice;

}