package com.poc.springbatch.model;

import jakarta.persistence.*;
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
@Table(name = "t_flux_collectives")
public class FluxCollectives {

    @Id
    @Column(name = "id_flx")
    private int idFlx;

    @Column(name = "num_ligne")
    private int numLigne;

    @Column(name = "code_fic", length = 90, nullable = false)
    private String codeFic;

    @Column(name = "contrat", length = 16)
    private String contrat;

    @Column(name = "souscont", length = 15)
    private String souscont;

    @Column(name = "scont", length = 21)
    private String scont;

    @Column(name = "gpcontrat", length = 19)
    private String gpcontrat;

    @Column(name = "regime", length = 14)
    private String regime;

    @Column(name = "siret", length = 24)
    private String siret;

    @Column(name = "siren", length = 19)
    private String siren;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_contrat", length = 1)
    private TypeContrat typeContrat;

    @Column(name = "raisoca", length = 40)
    private String raisoca;

    @Column(name = "nom_ent", length = 40)
    private String nomEnt;

    @Column(name = "code_gp", length = 20)
    private String codeGp;

    @Column(name = "dat_effet", length = 20)
    private String datEffet;

    @Column(name = "statut", length = 12)
    private String statut;

    @Column(name = "libelle_statut", length = 25)
    private String libelleStatut;

    @Column(name = "datsta", length = 20)
    private String datsta;

    @Column(name = "datstatp", length = 20)
    private String datstatp;

    @Column(name = "appelee", length = 20)
    private String appelee;

    @Column(name = "reglee", length = 20)
    private String reglee;

    @Column(name = "echeance", length = 20)
    private String echeance;

    @Column(name = "datdeb", length = 20)
    private String datdeb;

    @Column(name = "datfin", length = 20)
    private String datfin;

    @Column(name = "dat_der_reglee", length = 20)
    private String datDerReglee;

    @Column(name = "mnt_der_reglee", precision = 15, scale = 3)
    private BigDecimal mntDerReglee;

    @Column(name = "valport", precision = 15, scale = 3)
    private BigDecimal valport;

    @Column(name = "dtcompta", length = 20)
    private String dtcompta;

    @Column(name = "primht", precision = 15, scale = 3)
    private BigDecimal primht;

    @Column(name = "primttc", precision = 15, scale = 3)
    private BigDecimal primttc;

    @Enumerated(EnumType.STRING)
    @Column(name = "sens", length = 1)
    private Sens sens;

    @Column(name = "user_crea", length = 90, nullable = false)
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
