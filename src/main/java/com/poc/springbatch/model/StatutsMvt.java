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
@Table(name = "t_statuts_mvt")
public class StatutsMvt {

    @EmbeddedId
    private StatutsMvtId StatutsMvtId;

    @Column(name = "lib_statut", length = 150)
    private String libStatut;

    @Column(name = "desc_statut", length = 255)
    private String descStatut;

    @ManyToOne
    @JoinColumn(name = "code_bo", referencedColumnName = "code_bo", insertable = false, updatable = false)
    private BackOffice backOffice;

}
