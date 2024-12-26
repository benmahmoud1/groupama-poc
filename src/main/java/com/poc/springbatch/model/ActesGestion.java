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
@Table(name = "t_actes_gestion")
public class ActesGestion {


    @EmbeddedId
    private ActesGestionId actesGestionId;

    @Column(name = "lib_acte", length = 150)
    private String libActe;

    @Column(name = "desc_acte", length = 255)
    private String descActe;

    @ManyToOne
    @JoinColumn(name = "code_bo", referencedColumnName = "code_bo", insertable = false, updatable = false)
    private BackOffice backOffice;

}
