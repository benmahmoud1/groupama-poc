package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data  @NoArgsConstructor  @AllArgsConstructor @ToString
@Entity
@Builder
@Table(name = "t_in_data_calc_assietes")
@IdClass(FormatUniqueId.class)
public class FormatUnique {
    @Id
    @Column(name = "id_trt")
    private int idTrt;

    @Column(name = "num_ligne")
    private int numLigne;

    @Column(name = "id_flx_src")
    private Integer idFlxSrc;

    @Column(name = "num_ligne_src")
    private Integer numLigneSrc;

    @Column(name = "orig_flx", length = 90)
    private String origFlx;

    @Column(name = "cd_lot", length = 90)
    private String cdLot;

    @Column(name = "no_lot", length = 90)
    private String noLot;

    @Column(name = "dat_acte")
    private Date datActe;

    @Column(name = "cd_mvt", length = 90)
    private String cdMvt;

    @Column(name = "dat_creat_mvt", length = 90)
    private String datCreatMvt;

    @Column(name = "dat_eff_mvt")
    private LocalDateTime datEffMvt;

    @Column(name = "ctr_no_maj", length = 90)
    private String ctrNoMaj;

    @Column(name = "ctr_no_origin", length = 90)
    private String ctrNoOrigin;

    @Column(name = "ctr_cd_tarif", length = 90)
    private String ctrCdTarif;

    @Column(name = "ctr_categ", length = 90)
    private String ctrCateg;

    @Column(name = "ctr_version_tarif_categ", length = 90)
    private String ctrVersionTarifCateg;

    @Column(name = "ctr_duree_mois")
    private Integer ctrDureeMois;

    @Column(name = "ctr_duree_annee")
    private Integer ctrDureeAnnee;

    @Column(name = "ctr_duree_paiement_mois")
    private Integer ctrDureePaiementMois;

    @Column(name = "ctr_dat_eff")
    private Date ctrDatEff;

    @Column(name = "ctr_dern_prime_payee")
    private Date ctrDernPrimePayee;

    @Column(name = "ctr_nb_primes_payees")
    private Integer ctrNbPrimesPayees;

    @Column(name = "ctr_no_propo", length = 90)
    private String ctrNoPropo;

    @Column(name = "ctr_cd_nature_sortie", length = 90)
    private String ctrCdNatureSortie;

    @Column(name = "ass_id_grc", length = 90)
    private String assIdGrc;

    @Column(name = "ass_nom", length = 90)
    private String assNom;

    @Column(name = "ass_nom_jeune_fille", length = 150)
    private String assNomJeuneFille;

    @Column(name = "ass_prenom", length = 150)
    private String assPrenom;

    @Column(name = "ass_age_a_souscr")
    private Integer assAgeASouscr;

    @Column(name = "ass_date_naiss")
    private Date assDateNaiss;

    @Column(name = "prod_matricule", length = 90)
    private String prodMatricule;

    @Column(name = "prod_cle_matricule", length = 90)
    private String prodCleMatricule;

    @Column(name = "prod_cd_geo_ctr_ou_prod", length = 90)
    private String prodCdGeoCtrOuProd;

    @Column(name = "mnt_id_aia_prime", length = 90)
    private String mntIdAiaPrime;

    @Column(name = "mnt_pp_ttc")
    private Double mntPPTtc;

    @Column(name = "mnt_pp_ht")
    private Double mntPPHt;

    @Column(name = "mnt_dat_eff_prime")
    private Date mntDatEffPrime;

    @Column(name = "mnt_tx_frais_pp")
    private Double mntTxFraisPp;

    @Column(name = "mnt_respect_preco_pp", length = 90)
    private String mntRespectPrecoPp;

    @Column(name = "mnt_pp_ttc_prec")
    private Double mntPPTtcPrec;

    @Column(name = "mnt_pp_ht_prec")
    private Double mntPPHtPrec;

    @Column(name = "mnt_montant_vl")
    private Double mntMontantVl;

    @Column(name = "mnt_dat_eff_vl")
    private Date mntDatEffVl;

    @Column(name = "mnt_frais_vl")
    private Double mntFraisVl;

    @Column(name = "mnt_respect_preco_vl", length = 90)
    private String mntRespectPrecoVl;

    @Column(name = "mnt_type_vers", length = 90)
    private String mntTypeVers;

    @Column(name = "mnt_formule_gestion", length = 90)
    private String mntFormuleGestion;

    @Enumerated(EnumType.STRING)
    @Column(name = "ctr_presence_de_garantie_de_prev", length = 1)
    private PresenceGarantie ctrPresenceDeGarantieDePrev;


    @Column(name = "ctr_motif_principal_avenant", length = 90)
    private String ctrMotifPrincipalAvenant;

    @Column(name = "ctr_code_produit", length = 90)
    private String ctrCodeProduit;

    @Column(name = "dt_crea")
    private LocalDateTime dtCrea;

    @Column(name = "user_crea", length = 90)
    private String userCrea;

    @Column(name = "dt_upd")
    private LocalDateTime dtUpd;

    @Column(name = "user_upd", length = 90)
    private String userUpd;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", length = 2)
    private Statut statut;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat_mvt", length = 2)
    private EtatMvt etatMvt;

    @Column(name = "id_trt_blocage")
    private Integer idTrtBlocage;

    @Column(name = "num_ligne_blocage")
    private Integer numLigneBlocage;




}
