package com.poc.springbatch.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SqlResultSetMapping(name="VwRivageCptPrime0100.list", entities={
        @EntityResult(entityClass=VwRivageCptPrime0100.class)
})
@NamedNativeQuery(
        name = "query.VwRivageCptPrime0100.list",
        query = "SELECT vw.* " +
                "FROM vw_rivage_cpt_0100 vw " +
                "WHERE vw.cle_ident = :cle_ident " +
                "  AND vw.id_rappro = :id_rappro ",
        resultSetMapping = "VwRivageCptPrime0100.list"
)
@Data  @NoArgsConstructor  @AllArgsConstructor @ToString
@Entity
@Table(name = "vw_rivage_cpt_0100")
@IdClass(FluxId.class)
public class VwRivageCptPrime0100 {
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
    @Column(name="id_grc_de_l_apporteur")
    private String idGrcDeLApporteur;
    @Column(name="date_effet_d_origine_du_contrat")
    private String dateEffetDOrigineDuContrat;
    @Column(name="no_de_contrat_d_origine_aia")
    private String noDeContratDOrigineAia;
    @Column(name="identifiant_produit_d_origine")
    private String identifiantProduitDOrigine;
    @Column(name="indicateur_reprise_a_la_concurrence")
    private String indicateurRepriseALaConcurrence;
    @Column(name="id_cadre_fiscal_d_origine")
    private String idCadreFiscalDOrigine;
    @Column(name="Filler_0001")
    private String Filler0001;
    @Column(name="exercice_assurance")
    private String exerciceAssurance;
    @Column(name="statut_du_suivi_prime")
    private String statutDuSuiviPrime;
    @Column(name="motif_annulation")
    private String motifAnnulation;
    @Column(name="mt_total_mvt_ttc")
    private String mtTotalMvtTtc;
    @Column(name="mt_prime_pure")
    private String mtPrimePure;
    @Column(name="reste_a_rapprocher")
    private String resteARapprocher;
    @Column(name="code_association")
    private String codeAssociation;
    @Column(name="top_gestion_deleguee")
    private String topGestionDeleguee;
    @Column(name="top_preconisation")
    private String topPreconisation;
    @Column(name="date_de_prelevement")
    private String dateDePrelevement;
    @Column(name="date_de_valeur")
    private String dateDeValeur;
    @Column(name="Filler_0002")
    private String Filler0002;
    @Column(name="Filler_0003")
    private String Filler0003;
    @Column(name="mt_total_des_chargements")
    private String mtTotalDesChargements;
    @Column(name="Filler_0004")
    private String Filler0004;
    @Column(name="code_fractionnement")
    private String codeFractionnement;
    @Column(name="nombre_de_rejets_de_l_encaissement_prime")
    private String nombreDeRejetsDeLEncaissementPrime;
    @Column(name="montant_de_l_ajustem_tarifai_ventile_par_prime_pure_et_su")
    private String montantDeLAjustemTarifaiVentileParPrimePureEtSu;
    @Column(name="Filler_0005")
    private String Filler0005;
    @Column(name="origine_du_versement")
    private String origineDuVersement;
    @Column(name="date_debut_effet_prime")
    private String dateDebutEffetPrime;
    @Column(name="date_fin_effet_prime")
    private String dateFinEffetPrime;
    @Column(name="statut_precedent_prime")
    private String statutPrecedentPrime;
    @Column(name="identifiant_du_flux_annule")
    private String identifiantDuFluxAnnule;
    @Column(name="type_de_la_prestation_d_origine")
    private String typeDeLaPrestationDOrigine;
    @Column(name="code_production")
    private String codeProduction;
    @Column(name="code_origine_des_fonds")
    private String codeOrigineDesFonds;
    @Column(name="mode_de_paiement")
    private String modeDePaiement;
    @Column(name="code_marketing_1")
    private String codeMarketing1;
    @Column(name="montant_de_l_ajustement_tarifaire_1")
    private String montantDeLAjustementTarifaire1;
    @Column(name="code_marketing_2")
    private String codeMarketing2;
    @Column(name="montant_de_l_ajustement_tarifaire_2")
    private String montantDeLAjustementTarifaire2;
    @Column(name="code_marketing_3")
    private String codeMarketing3;
    @Column(name="montant_de_l_ajustement_tarifaire_3")
    private String montantDeLAjustementTarifaire3;
    @Column(name="Filler_0006")
    private String Filler0006;
}
