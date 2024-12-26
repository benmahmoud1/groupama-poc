package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_flux_protection_juridique")
public class FluxProtectionJuridique {

    @Id
    @Column(name = "id_flx")
    private int idFlx;

    @Column(name = "num_ligne")
    private int numLigne;

    @Column(name = "datemvt", length = 20)
    private String datemvt;

    @Column(name = "pol", length = 20)
    private String pol;

    @Column(name = "tc", length = 10)
    private String tc;

    @Column(name = "noma", length = 100)
    private String noma;

    @Column(name = "prenoma", length = 100)
    private String prenoma;

    @Column(name = "effet", length = 8)
    private String effet;

    @Column(name = "mvt", length = 90)
    private String mvt;

    @Column(name = "pricom", precision = 15, scale = 3)
    private BigDecimal pricom;

    @Column(name = "mtretro", precision = 15, scale = 3)
    private BigDecimal mtretro;

    @Column(name = "matpro", length = 10)
    private String matpro;

    @Column(name = "cle", length = 5)
    private String cle;

    @Column(name = "cd_geo", length = 90)
    private String cdGeo;

    @Column(name = "txmino", precision = 15, scale = 3)
    private BigDecimal txmino;

    @Column(name = "user_crea", length = 90, nullable = false, columnDefinition = "varchar(90) default 'SYSTEM'")
    private String userCrea;

    @Column(name = "dt_crea")
    private LocalDateTime dtCrea;

    @Column(name = "user_upd", length = 90)
    private String userUpd;

    @Column(name = "dt_upd")
    private LocalDateTime dtUpd;

    @Column(name = "statut_flx", length = 90)
    private String statutFlx;
}
