package com.poc.springbatch.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
@SqlResultSetMapping(name="mapVwRivageAdmin9200.list", entities={
        @EntityResult(entityClass=VwRivageAdmin9200.class)
})
@NamedNativeQuery(
        name = "query.VwRivageAdmin9200.list",
        query = "SELECT vw.* " +
                "FROM vw_rivage_admin_9200 vw " +
                "WHERE vw.cle_ident = :cle_ident " +
                "  AND vw.id_rappro = :id_rappro ",
        resultSetMapping = "mapVwRivageAdmin9200.list"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vw_rivage_admin_9200")
@IdClass(FluxId.class)
public class VwRivageAdmin9200 {
    @Id
    @Column(name="id_flx")
    private long idFlx;
    @Id
    @Column(name="num_ligne")
    private long numLigne;

    // Début : Champs supplémentaires
    @Column(name="source_flx")
    private String sourceFlx;
    @Column(name="type_ligne")
    private String typeLigne;
    @Column(name="cle_ident")
    private String cleIdent;
    @Column(name="id_rappro")
    private String idRappro;
    @Column(name="statut_flx")
    private String statutFlx;
    @Column(name="dt_crea")
    private LocalDateTime dtCrea;
    @Column(name="dt_upd")
    private LocalDateTime dtUpd;
    // Fin : Champs supplémentaires

    @Column(name="Filler_0001")
    private String Filler0001;
    @Column(name="identifiant")
    private String identifiant;
    @Column(name="date_de_debut")
    private String dateDeDebut;
    @Column(name="date_de_fin")
    private String dateDeFin;
    @Column(name="type")
    private String type;
    @Column(name="type_d_echeance")
    private String typeDEcheance;
    @Column(name="identifiant_payeur")
    private String identifiantPayeur;
    @Column(name="type_d_attachement")
    private String typeDAttachement;
    @Column(name="type_de_payeur")
    private String typeDePayeur;
    @Column(name="periodicite")
    private String periodicite;
    @Column(name="type_de_paiement")
    private String typeDePaiement;
    @Column(name="jour_de_prelevement")
    private String jourDePrelevement;
    @Column(name="statut")
    private String statut;
    @Column(name="date_de_debut_de_suspension")
    private String dateDeDebutDeSuspension;
    @Column(name="date_de_fin_de_suspension")
    private String dateDeFinDeSuspension;
    @Column(name="flag_de_cre_062_a_selectionner_ou_non")
    private String flagDeCre062ASelectionnerOuNon;
    @Column(name="mt_de_l_augment_ou_diminut_de_l_engagem_de_l_assure")
    private String mtDeLAugmentOuDiminutDeLEngagemDeLAssure;
    @Column(name="canal")
    private String canal;
    @Column(name="origine")
    private String origine;
    @Column(name="reference_du_periph_externe")
    private String referenceDuPeriphExterne;
    @Column(name="code_marketing")
    private String codeMarketing;
    @Column(name="motif_de_suspension_du_plan_de_vlp")
    private String motifDeSuspensionDuPlanDeVlp;
    @Column(name="motif_de_suspension_du_plan_de_rpp")
    private String motifDeSuspensionDuPlanDeRpp;
    @Column(name="date_debut_indexation_vlp")
    private String dateDebutIndexationVlp;
    @Column(name="date_de_prochaine_echeance_indexation_vlp")
    private String dateDeProchaineEcheanceIndexationVlp;
    @Column(name="taux_indexation_vlp")
    private String tauxIndexationVlp;
    @Column(name="montant_de_la_prime_vlp_indexee")
    private String montantDeLaPrimeVlpIndexee;
    @Column(name="date_de_la_derniere_indexation_vlp_realisee")
    private String dateDeLaDerniereIndexationVlpRealisee;
    @Column(name="motif_de_suspension_du_plan_de_rpp_ou_vlp")
    private String motifDeSuspensionDuPlanDeRppOuVlp;
    @Column(name="indicateur_brut_net_pour_les_rachats")
    private String indicateurBrutNetPourLesRachats;
    @Column(name="indicateur_contrat_avec_vlp_indexe_ou_non")
    private String indicateurContratAvecVlpIndexeOuNon;
    @Column(name="montant_prime_commerciale_annuelle_ttc")
    private String montantPrimeCommercialeAnnuelleTtc;
    @Column(name="montant_prime_commerciale_annuelle_ht")
    private String montantPrimeCommercialeAnnuelleHt;
    @Column(name="montant_taxes_de_la_prime_commerciale_annuelle")
    private String montantTaxesDeLaPrimeCommercialeAnnuelle;
    @Column(name="montant_ht_des_frais_de_fractio_de_la_prime_commerc")
    private String montantHtDesFraisDeFractioDeLaPrimeCommerc;
    @Column(name="demande_prelevement")
    private String demandePrelevement;
    @Column(name="date_du_1er_prelevement")
    private String dateDu1erPrelevement;
    @Column(name="date_effet_proch_prelevt")
    private String dateEffetProchPrelevt;
    @Column(name="montant_prelevement")
    private String montantPrelevement;
    @Column(name="code_fractionnement_prelevement")
    private String codeFractionnementPrelevement;
    @Column(name="demande_retrait_prog")
    private String demandeRetraitProg;
    @Column(name="date_du_1er_retrait_prog")
    private String dateDu1erRetraitProg;
    @Column(name="date_effet_proch_ret_pgm")
    private String dateEffetProchRetPgm;
    @Column(name="montant_retrait_prog")
    private String montantRetraitProg;
    @Column(name="code_fractionnement_retrait")
    private String codeFractionnementRetrait;
    @Column(name="precedent_montant_prime_annuelle_ttc")
    private String precedentMontantPrimeAnnuelleTtc;
    @Column(name="precedent_indicateur_indexation")
    private String precedentIndicateurIndexation;
    @Column(name="top_gestion_deleguee")
    private String topGestionDeleguee;
    @Column(name="top_preconisation")
    private String topPreconisation;
    @Column(name="motif_rachat")
    private String motifRachat;
    @Column(name="taux_de_frais_pp_ou_vlp")
    private String tauxDeFraisPpOuVlp;
    @Column(name="montant_pp_ou_vlp_ht_precedent")
    private String montantPpOuVlpHtPrecedent;
    @Column(name="duree_du_paiement_en_mois")
    private String dureeDuPaiementEnMois;

}
