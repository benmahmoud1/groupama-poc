package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "t_flux_expertisimo" )
public class FluxExpertisimo {

    @Id
    @Column(name = "id_flx", nullable = false)
    private int idFlx;

    @Id
    @Column(name = "num_ligne", nullable = false)
    private int numLigne;

    @Column(name = "datemvt")
    private LocalDate dateMvt;

    @Column(name = "numcontrat", length = 90)
    private String numContrat;

    @Column(name = "mvt", length = 90)
    private String mvt;

    @Column(name = "effet", length = 8)
    private String effet;

    @Column(name = "matpro", length = 10)
    private String matpro;

    @Column(name = "cle", length = 5)
    private String cle;

    @Column(name = "cd_geo", length = 90)
    private String cdGeo;

    @Column(name = "tc", length = 10)
    private String tc;

    @Column(name = "noma", length = 100)
    private String noma;

    @Column(name = "prenoma", length = 100)
    private String prenoma;

    @Column(name = "primht", precision = 15, scale = 3)
    private BigDecimal primHt;

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

