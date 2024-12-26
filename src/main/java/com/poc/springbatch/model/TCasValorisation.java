package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.*;

@Data  @NoArgsConstructor @AllArgsConstructor @ToString
@Builder
@Entity
@Table(name = "t_cas_valorisation")
public class TCasValorisation {

    @Id
    @Column(name = "code_cas", nullable = false, length = 90)
    private String codeCas;

    @Column(name = "lib_cas", length = 150)
    private String libCas;

    @Column(name = "desc_cas", length = 255)
    private String descCas;

    @Column(name = "flux_maitre", length = 255)
    private String fluxMaitre;

    @ManyToOne
    @JoinColumn(name = "code_bo")
    private BackOffice backOffice;


}