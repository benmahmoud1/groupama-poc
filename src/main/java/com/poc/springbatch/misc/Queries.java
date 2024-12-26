package com.poc.springbatch.misc;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class Queries {

    public final static String SELECT_PRESENCE_PREV = "Select count(*)  " +
                                                    "From t_code_garantie gar  " +
                                                    "inner join vw_rivage_admin_9110 adm_9110 On adm_9110.code_garantie = gar.code_garantie_rivage " +
                                                    "inner join vw_rivage_admin_gc adm_gc on adm_gc.cle_ident = adm_9110.cle_ident " +
                                                    "                                    and adm_gc.id_rappro = adm_9110.id_rappro " +
                                                    "                                    and adm_gc.code_produit = gar.code_produit " +
                                                    "Where adm_gc.date_effet_du_mvt <=  adm_9110.date_fin_de_garantie " +
                                                    "  AND adm_gc.cle_ident = :cle_ident  " +
                                                    "  AND adm_gc.id_rappro = :id_rappro " +
                                                    "  AND adm_gc.id_flx = :id_flx ";

    public final static String SELECT_TARIF_CATEG = "SELECT distinct prod.tarif, prod.categorie, prod.version " +
                                                    "FROM vw_rivage_admin_gc adm_gc " +
                                                    "INNER JOIN t_code_produit_rivage prod ON prod.code_produit = adm_gc.code_produit  " +
                                                    "WHERE adm_gc.cle_ident = :cle_ident  " +
                                                    "  AND adm_gc.id_rappro = :id_rappro " +
                                                    "  AND adm_gc.id_flx = :id_flx ";

    public final static String SELECT_FORMULE = "SELECT distinct formule.code_formule codeFormule, formule.code_gt_aia codeGtAia " +
                                                "FROM vw_rivage_admin_gc adm_gc " +
                                                "INNER JOIN t_code_formule formule ON formule.Code_gt_aia = adm_gc.orientation_de_gestion_profil_de_gestion " +
                                                "  AND adm_gc.code_produit=formule.code_produit " +
                                                "WHERE adm_gc.cle_ident = :cle_ident " +
                                                "  AND adm_gc.id_rappro = :id_rappro " +
                                                "  AND adm_gc.id_flx = :id_flx ";
    public final static String UPDATE_SEQUENCE_FLX = "UPDATE t_rubriques_de_donnees " +
                                                     "SET valeur_rubrique = :valeur_rubrique " +
                                                     "WHERE code_rubrique = :code_rubrique";

    public final static String SELECT_SEQUENCE_FLX = "SELECT  valeur_rubrique  " +
                                                     "FROM t_rubriques_de_donnees " +
                                                     "WHERE code_rubrique = :code_rubrique";
    public final static String UPDATE_FORMAT_FIX_STATUT = "UPDATE t_flux_brut_fmnt_fixe " +
                                                        "SET statut_flx = :statut_flx " +
                                                        "WHERE cle_ident = :cle_ident " +
                                                        "  AND id_rappro = :id_rappro";
    public final static String SEL_ITEMS_CRE_ADMIN = "SELECT distinct alias.id_flx idFlx, " +
                                                    "alias.cle_ident cleIdent, " +
                                                    "alias.id_rappro idRappro " +
                                                    "FROM vw_rivage_admin_gc alias " +
                                                    "WHERE alias.statut_flx = :statut_flx " +
                                                    " AND alias.cle_ident IN ('VLDTPRPSN', 'AUTO_PROP_TRSNFR', 'NB')";

    public final static String SEL_ITEMS_CRE_COMPTA = "SELECT distinct alias.id_flx idFlx, " +
                                                    "alias.cle_ident cleIdent, " +
                                                    "alias.id_rappro idRappro " +
                                                    "FROM vw_rivage_cpt_gc alias " +
                                                    "WHERE alias.statut_flx = :statut_flx";

    public final static String SEL_ORDO_VALO = "SELECT cas.flux_maitre fluxMaitre, " +
                                                "       ordo.num_ordre numOrdre, " +
                                                "       ordo.code_Cas_Princ codeCasPrinc, " +
                                                "       ordo.code_Cas_Second codeCasSecond, " +
                                                "       ordo.actif actif " +
                                                "FROM t_carto_ordonnancement_valorisation ordo " +
                                                "INNER JOIN t_cas_valorisation cas ON cas.code_cas = ordo.code_cas_princ " +
                                                "WHERE ordo.actif = :actif " +
                                                "AND cas.code_bo = :code_bo ";
    public final static String SEL_REGLE_VALO = "SELECT  cas.flux_maitre fluxMaitre, " +
                                                "regle.code_cas codeCas," +
                                                 "regle.no_sequence noSequence," +
                                                "regle.nom_champ_format_unique nomChampFormatUnique," +
                                                "regle.no_critere noCritere," +
                                                "regle.obligatoire," +
                                                "regle.valeur_par_defaut valeurParDefaut," +
                                                "regle.condition_valo conditionValo," +
                                                "regle.condition_valo_technique conditionValoTechnique," +
                                                "regle.expression_valeur expressionValeur," +
                                                "regle.expression_valeur_technique expressionValeurTechnique," +
                                                "regle.code_regle codeRegle," +
                                                "regle.code_message codeMessage," +
                                                "regle.texte_info_message texteInfoMessage," +
                                                "regle.texte_erreur_message texteErreurMessage " +
                                                "FROM t_regles_valorisation regle " +
                                                "INNER JOIN t_cas_valorisation cas ON cas.code_cas = regle.code_cas " +
                                                "WHERE cas.code_bo = :code_bo " +
                                                "ORDER BY regle.code_cas, " +
                                                "regle.no_sequence, " +
                                                "regle.no_critere";

}
