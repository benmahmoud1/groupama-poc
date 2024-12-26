package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.poc.springbatch.misc.Queries.*;

@SqlResultSetMapping(name = "mapIemsCreComptaCharge",
        classes = {
                @ConstructorResult(targetClass = ItemFlux.class, columns = {
                        @ColumnResult(name = "idFlx", type = Long.class),
                        @ColumnResult(name = "cleIdent", type = String.class),
                        @ColumnResult(name = "idRappro", type = String.class)
                })
        })
@NamedNativeQuery(
        name = "query.SEL_ITEMS_CRE_COMPTA",
        query = SEL_ITEMS_CRE_COMPTA,
        resultSetMapping = "mapIemsCreComptaCharge"
)

@NamedNativeQuery(
        name = "query.CreComptaCharge",
        query = "SELECT gc.* " +
                "FROM vw_rivage_cpt_gc gc " +
                "WHERE gc.statut_flx = :statut_flx",
        resultSetMapping = "mapCreComptaCharge"
)
@SqlResultSetMapping(name="mapCreComptaCharge", entities={
        @EntityResult(entityClass=VwRivageCptGc.class)
})

@SqlResultSetMapping(name="VwRivageCptGc.list", entities={
        @EntityResult(entityClass=VwRivageCptGc.class)
})
@NamedNativeQuery(
        name = "query.VwRivageCptGc.list",
        query = "SELECT vw.* " +
                "FROM vw_rivage_cpt_gc vw " +
                "WHERE vw.cle_ident = :cle_ident " +
                "  AND vw.id_rappro = :id_rappro ",
        resultSetMapping = "VwRivageCptGc.list"
)
@Data  @NoArgsConstructor  @AllArgsConstructor @ToString
@Entity
@Table(name = "vw_rivage_cpt_gc")
@IdClass(FluxId.class)
public class VwRivageCptGc {
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

    @Column(name="code_evenement_xrdj")
    private String codeEvenementXrdj;
    @Column(name="type_d_enregistrement")
    private String typeDEnregistrement;
    @Column(name="code_instance")
    private String codeInstance;
    @Column(name="date_d_application")
    private String dateDApplication;
    @Column(name="identifiant_de_compostage")
    private String identifiantDeCompostage;
    @Column(name="code_lot")
    private String codeLot;
    @Column(name="no_version_fichier")
    private String noVersionFichier;
    @Column(name="code_regle_ews")
    private String codeRegleEws;
    @Column(name="systeme_emetteur")
    private String systemeEmetteur;
    @Column(name="code_centre_de_profit")
    private String codeCentreDeProfit;
    @Column(name="top_equi")
    private String topEqui;
    @Column(name="top_ext")
    private String topExt;
    @Column(name="date_confection_du_flux")
    private String dateConfectionDuFlux;
    @Column(name="indicateur_de_modification")
    private String indicateurDeModification;
    @Column(name="no_lot_extraction_csc")
    private String noLotExtractionCsc;
    @Column(name="indicateur_combinaison_inconnue_dans_matrice")
    private String indicateurCombinaisonInconnueDansMatrice;
    @Column(name="Filler_0001")
    private String Filler0001;
    @Column(name="code_acte_de_gestion")
    private String codeActeDeGestion;
    @Column(name="nature_mouvement")
    private String natureMouvement;
    @Column(name="type_du_mouvement")
    private String typeDuMouvement;
    @Column(name="status_mouvement")
    private String statusMouvement;
    @Column(name="no_du_mouveme_interne_aia_prime_prestat_arbitra_snpp_et")
    private String noDuMouvemeInterneAiaPrimePrestatArbitraSnppEt;
    @Column(name="date_comptable")
    private String dateComptable;
    @Column(name="date_de_comptabilisation")
    private String dateDeComptabilisation;
    @Column(name="date_operation")
    private String dateOperation;
    @Column(name="date_effet_du_mvt")
    private String dateEffetDuMvt;
    @Column(name="entite_juridique")
    private String entiteJuridique;
    @Column(name="code_produit")
    private String codeProduit;
    @Column(name="famille_de_produit")
    private String familleDeProduit;
    @Column(name="contrat")
    private String contrat;
    @Column(name="date_1ere_prime_impayee")
    private String date1erePrimeImpayee;
    @Column(name="etat_contrat")
    private String etatContrat;
    @Column(name="motif_etat_contrat")
    private String motifEtatContrat;
    @Column(name="date_effet_du_contrat")
    private String dateEffetDuContrat;
    @Column(name="code_enveloppe_fiscale")
    private String codeEnveloppeFiscale;
    @Column(name="code_pays_souscripteur")
    private String codePaysSouscripteur;
    @Column(name="code_pays_fiscal_du_souscripteur")
    private String codePaysFiscalDuSouscripteur;
    @Column(name="domiciliation_fiscale")
    private String domiciliationFiscale;
    @Column(name="code_geographique_gan_prevoyance")
    private String codeGeographiqueGanPrevoyance;
    @Column(name="niveau_1_structure_commerciale")
    private String niveau1StructureCommerciale;
    @Column(name="niveau_2_structure_commerciale")
    private String niveau2StructureCommerciale;
    @Column(name="niveau_3_structure_commerciale")
    private String niveau3StructureCommerciale;
    @Column(name="niveau_4_structure_commerciale")
    private String niveau4StructureCommerciale;
    @Column(name="niveau_5_structure_commerciale")
    private String niveau5StructureCommerciale;
    @Column(name="indicateur_epargne_handicap")
    private String indicateurEpargneHandicap;
    @Column(name="indicateur_rente_survie")
    private String indicateurRenteSurvie;
    @Column(name="type_produit")
    private String typeProduit;
    @Column(name="date_effet_d_origine_du_contrat")
    private String dateEffetDOrigineDuContrat;
    @Column(name="no_de_contrat_d_origine_aia")
    private String noDeContratDOrigineAia;
    @Column(name="origine_du_transfert_identifiant_produit_d_origine")
    private String origineDuTransfertIdentifiantProduitDOrigine;
    @Column(name="code_utilisateur_ayant_genere_l_acte_gestion")
    private String codeUtilisateurAyantGenereLActeGestion;
    @Column(name="indicateur_salarie")
    private String indicateurSalarie;
    @Column(name="indicateur_offre_promotionnelle")
    private String indicateurOffrePromotionnelle;
    @Column(name="date_de_signature")
    private String dateDeSignature;
    @Column(name="canal")
    private String canal;
    @Column(name="origine")
    private String origine;
    @Column(name="ref_du_periph_externe")
    private String refDuPeriphExterne;
    @Column(name="code_marketing")
    private String codeMarketing;
    @Column(name="date_de_valeur_du_mouvement")
    private String dateDeValeurDuMouvement;
    @Column(name="mode_de_gestion_du_contrat")
    private String modeDeGestionDuContrat;
    @Column(name="orientation_de_gestion_profil_de_gestion")
    private String orientationDeGestionProfilDeGestion;
    @Column(name="contexte_du_produit")
    private String contexteDuProduit;
    @Column(name="id_apporteur_type_de_l_evenement")
    private String idApporteurTypeDeLEvenement;
    @Column(name="niveau_de_traitement")
    private String niveauDeTraitement;
    @Column(name="indicateur_financier")
    private String indicateurFinancier;
    @Column(name="date_de_connaissance_de_l_evenement_generateur")
    private String dateDeConnaissanceDeLEvenementGenerateur;
    @Column(name="indicateur_reprise_a_la_concurrence")
    private String indicateurRepriseALaConcurrence;
    @Column(name="filler_id_cadre_fiscal_d_origine")
    private String fillerIdCadreFiscalDOrigine;
    @Column(name="timestamp_de_l_a_g")
    private String timestampDeLAG;
    @Column(name="no_proposition")
    private String noProposition;
    @Column(name="date_statut")
    private String dateStatut;
    @Column(name="reference_offre_promotionnelle")
    private String referenceOffrePromotionnelle;
    @Column(name="mode_de_gestion_du_contrat_precedent")
    private String modeDeGestionDuContratPrecedent;
    @Column(name="orientation_de_gestion_profil_de_gestion_precedent")
    private String orientationDeGestionProfilDeGestionPrecedent;
    @Column(name="taux_de_repartition_gpat")
    private String tauxDeRepartitionGpat;
    @Column(name="code_produit_technique")
    private String codeProduitTechnique;
    @Column(name="date_derniere_prime_payee")
    private String dateDernierePrimePayee;
    @Column(name="code_source_produits_s2")
    private String codeSourceProduitsS2;
    @Column(name="identifiant_du_plan_de_reprise")
    private String identifiantDuPlanDeReprise;
    @Column(name="date_d_effet_de_l_evenement_generateur")
    private String dateDEffetDeLEvenementGenerateur;
}
