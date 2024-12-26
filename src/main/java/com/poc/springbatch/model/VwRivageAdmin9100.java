package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

import static com.poc.springbatch.misc.Queries.SEL_ORDO_VALO;

@SqlResultSetMapping(name="mapVwRivageAdmin9100.list", entities={
        @EntityResult(entityClass=VwRivageAdmin9100.class)
})
@NamedNativeQuery(
        name = "query.VwRivageAdmin9100.list",
        query = "SELECT vw.* " +
                "FROM vw_rivage_admin_9100 vw " +
                "WHERE vw.cle_ident = :cle_ident " +
                "  AND vw.id_rappro = :id_rappro ",
        resultSetMapping = "mapVwRivageAdmin9100.list"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vw_rivage_admin_9100")
@IdClass(FluxId.class)
public class VwRivageAdmin9100 {
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
    @Column(name="no_contrat")
    private String noContrat;
    @Column(name="date_effet_de_l_etat_du_contrat")
    private String dateEffetDeLEtatDuContrat;
    @Column(name="etat_du_contrat")
    private String etatDuContrat;
    @Column(name="motif_etat")
    private String motifEtat;
    @Column(name="type_fiscalite")
    private String typeFiscalite;
    @Column(name="no_proposition")
    private String noProposition;
    @Column(name="statut_de_la_proposition")
    private String statutDeLaProposition;
    @Column(name="taux_de_revalorisation")
    private String tauxDeRevalorisation;
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
    @Column(name="indicateur_brut_net_pour_les_rachats")
    private String indicateurBrutNetPourLesRachats;
    @Column(name="valeur_de_rachat_en_date_de_sortie")
    private String valeurDeRachatEnDateDeSortie;
    @Column(name="indicateur_financier")
    private String indicateurFinancier;
    @Column(name="nom_de_l_assure_principal")
    private String nomDeLAssurePrincipal;
    @Column(name="prenom_de_l_assure_principal")
    private String prenomDeLAssurePrincipal;
    @Column(name="date_terme_du_contrat")
    private String dateTermeDuContrat;
    @Column(name="code_partage")
    private String codePartage;
    @Column(name="id_souscripteur")
    private String idSouscripteur;
    @Column(name="nom_du_soucripteur")
    private String nomDuSoucripteur;
    @Column(name="prenom_du_souscripteur")
    private String prenomDuSouscripteur;
    @Column(name="indicateur_vip_du_souscripteur")
    private String indicateurVipDuSouscripteur;
    @Column(name="nom_de_jeune_fille_de_l_assure")
    private String nomDeJeuneFilleDeLAssure;
    @Column(name="precedent_etat_du_contrat")
    private String precedentEtatDuContrat;
    @Column(name="indicateur_indexation_revalorisation_contrat")
    private String indicateurIndexationRevalorisationContrat;
    @Column(name="id_souscripteur_0001")
    private String idSouscripteur0001;
    @Column(name="nom_du_soucripteur_0001")
    private String nomDuSoucripteur0001;
    @Column(name="prenom_du_souscripteur_0001")
    private String prenomDuSouscripteur0001;
    @Column(name="id_souscripteur_0002")
    private String idSouscripteur0002;
    @Column(name="nom_du_soucripteur_0002")
    private String nomDuSoucripteur0002;
    @Column(name="prenom_du_souscripteur_0002")
    private String prenomDuSouscripteur0002;
    @Column(name="type_d_evenement_principal")
    private String typeDEvenementPrincipal;
    @Column(name="identifiant_aia_du_payeur")
    private String identifiantAiaDuPayeur;
    @Column(name="identifiant_aia_de_l_assure_principal")
    private String identifiantAiaDeLAssurePrincipal;
    @Column(name="code_contrat_origine")
    private String codeContratOrigine;
    @Column(name="code_clause")
    private String codeClause;
    @Column(name="type_de_clause")
    private String typeDeClause;

    @Column(name="id_grc_assure_principal")
    private String idGrcAssurePrincipal;

    @Column(name="motif_de_l_etat_precedent_du_contrat")
    private String motifDeLEtatPrecedentDuContrat;

    @Column(name="date_de_naissance_de_l_assure_principal")
    private String dateDeNaissanceDeLAssurePrincipal;

}
