package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@SqlResultSetMapping(name="VwRivageCptPrime0101.list", entities={
        @EntityResult(entityClass=VwRivageCptPrime0101.class)
})
@NamedNativeQuery(
        name = "query.VwRivageCptPrime0101.list",
        query = "SELECT vw.* " +
                "FROM vw_rivage_cpt_0101 vw " +
                "WHERE vw.cle_ident = :cle_ident " +
                "  AND vw.id_rappro = :id_rappro ",
        resultSetMapping = "VwRivageCptPrime0101.list"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vw_rivage_cpt_0101")
@IdClass(FluxId.class)
public class VwRivageCptPrime0101 {
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
    @Column(name="Filler_0001")
    private String Filler0001;
    @Column(name="code_garantie")
    private String codeGarantie;
    @Column(name="code_type_garantie")
    private String codeTypeGarantie;
    @Column(name="type_de_support")
    private String typeDeSupport;
    @Column(name="code_support")
    private String codeSupport;
    @Column(name="type_de_frais")
    private String typeDeFrais;
    @Column(name="type_de_frais_ventile")
    private String typeDeFraisVentile;
    @Column(name="destinataire_du_frais_ventile")
    private String destinataireDuFraisVentile;
    @Column(name="element_technique")
    private String elementTechnique;
    @Column(name="option_d_arbitrage")
    private String optionDArbitrage;
    @Column(name="montant_frais")
    private String montantFrais;
    @Column(name="code_assisteur")
    private String codeAssisteur;
    @Column(name="type_de_calcul")
    private String typeDeCalcul;
    @Column(name="valeur_de_chargement")
    private String valeurDeChargement;
    @Column(name="valeur_globale_de_chargement")
    private String valeurGlobaleDeChargement;
    @Column(name="valeur_theorique_de_chargement")
    private String valeurTheoriqueDeChargement;
    @Column(name="valeur_theorique_globale_de_chargement")
    private String valeurTheoriqueGlobaleDeChargement;
    @Column(name="code_du_motif_de_derogation")
    private String codeDuMotifDeDerogation;
    @Column(name="numero_de_la_garantie_sur_le_contrat")
    private String numeroDeLaGarantieSurLeContrat;
    @Column(name="montant_de_l_ajustement_tarifaire_ventile_par_frais")
    private String montantDeLAjustementTarifaireVentileParFrais;
    @Column(name="objectif_du_projet")
    private String objectifDuProjet;
    @Column(name="profil_de_gestion_du_projet")
    private String profilDeGestionDuProjet;
    @Column(name="duree_du_projet")
    private String dureeDuProjet;
    @Column(name="numero_du_projet")
    private String numeroDuProjet;
    @Column(name="date_debut_du_projet")
    private String dateDebutDuProjet;
    @Column(name="date_fin_du_projet")
    private String dateFinDuProjet;
    @Column(name="Filler_0002")
    private String Filler0002;
    @Column(name="Filler_0003")
    private String Filler0003;
    @Column(name="mode_de_gestion_maille_garantie_support")
    private String modeDeGestionMailleGarantieSupport;
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
    @Column(name="code_marketing_4")
    private String codeMarketing4;
    @Column(name="montant_de_l_ajustement_tarifaire_4")
    private String montantDeLAjustementTarifaire4;
    @Column(name="code_marketing_5")
    private String codeMarketing5;
    @Column(name="montant_de_l_ajustement_tarifaire_5")
    private String montantDeLAjustementTarifaire5;
    @Column(name="code_marketing_6")
    private String codeMarketing6;
    @Column(name="montant_de_l_ajustement_tarifaire_6")
    private String montantDeLAjustementTarifaire6;
    @Column(name="Filler_0004")
    private String Filler0004;
}
