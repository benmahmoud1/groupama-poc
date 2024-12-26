package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_flux_groupama_es",
        indexes = {
                @Index(name = "idx_flux_groupama_police", columnList = "police"),
                @Index(name = "idx_flux_groupama_dt_adhesion", columnList = "dt_adhesion")
        })
public class FluxGroupama {

    @Id
    @Column(name = "id_flx", nullable = false)
    private int idFlx;

    @Id
    @Column(name = "num_ligne", nullable = false)
    private int numLigne;

    @Column(name = "police", length = 90)
    private String police;

    @Column(name = "raison_sociale", length = 100)
    private String raisonSociale;

    @Column(name = "type_plan", length = 90)
    private String typePlan;

    @Column(name = "dt_adhesion")
    private LocalDate dtAdhesion;

    @Column(name = "dt_mouvement")
    private LocalDate dtMouvement;

    @Column(name = "mouvement", length = 90)
    private String mouvement;

    @Column(name = "mtt_versement", precision = 15, scale = 3)
    private BigDecimal mttVersement;

    @Column(name = "mtt_retro", precision = 15, scale = 3)
    private BigDecimal mttRetro;

    @Column(name = "comm", length = 90)
    private String comm;

    @Column(name = "matpro", length = 10)
    private String matpro;

    @Column(name = "clemat", length = 90)
    private String clemat;

    @Column(name = "codgrad", length = 90)
    private String codgrad;

    @Column(name = "codgeo", length = 90)
    private String codgeo;

    @Column(name = "txmino", precision = 15, scale = 3)
    private BigDecimal txmino;

    @Column(name = "user_crea", nullable = false, length = 90)
    private String userCrea = "SYSTEM";

    @Column(name = "dt_crea")
    private LocalDateTime dtCrea;

    @Column(name = "user_upd", length = 90)
    private String userUpd;

    @Column(name = "dt_upd")
    private LocalDateTime dtUpd;

    @Column(name = "statut_flx", length = 90)
    private String statutFlx;
}
