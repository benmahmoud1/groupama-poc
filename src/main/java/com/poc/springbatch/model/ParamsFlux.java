package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "t_params_flux")
public class ParamsFlux {

    @Id
    @Column(name = "id_flux", nullable = false)
    private Long idFlux;

    @Column(name = "nom_flux", nullable = false, length = 255)
    private String nomFlux;

    @Column(name = "desc_flux", length = 255)
    private String descFlux;

    @ManyToOne
    @JoinColumn(name = "source_flux")
    private BackOffice sourceFlux;

    @Column(name = "frequence")
    private String frequence;

    @Column(name = "nature")
    private String nature;

    @Column(name = "flux_actif")
    private String fluxActif;

    @Column(name = "user_crea", length = 90)
    private String userCrea;

    @Column(name = "dat_crea")
    private LocalDateTime datCrea;

    @Column(name = "user_upd", length = 90)
    private String userUpd;

    @Column(name = "dat_upd")
    private LocalDateTime datUpd;
}
