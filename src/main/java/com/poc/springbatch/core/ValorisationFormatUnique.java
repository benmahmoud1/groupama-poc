package com.poc.springbatch.core;

import com.poc.springbatch.model.FormatUnique;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public abstract class ValorisationFormatUnique implements IValorisationFormatUnique {

  /*  public void setValue(FormatUnique pInstanceFormatUnique, String pNomAttribut, Object pValue) {
        *//*
        Method[] methods = pInstanceFormatUnique.getClass().getMethods();
        for (Method method : methods) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + method);
        }
        *//*
        switch (pNomAttribut.toLowerCase()) {
            case "ctr_code_produit" :
            case "ctrcodeproduit" :
                pInstanceFormatUnique.setCtrCodeProduit((String) pValue);
                break;
            case "ctr_no_propo" :
            case "ctrnopropo" :
                pInstanceFormatUnique.setCtrNoPropo((String) pValue);
                break;
            case "cd_mvt" :
            case "cdMvt" :
                pInstanceFormatUnique.setCdMvt((String) pValue);
                break;
            case "no_lot" :
            case "nolot" :
                pInstanceFormatUnique.setNoLot((String) pValue);
                break;
            case "cd_lot" :
            case "cdlot" :
                pInstanceFormatUnique.setCdLot((String) pValue);
                break;
            case "ctrdureemois":
            case "ctr_duree_mois":
                pInstanceFormatUnique.setCtrDureeMois((Integer) pValue);
                break;
            case "ctrdureeannee":
            case "ctr_duree_annee":
                pInstanceFormatUnique.setCtrDureeAnnee((Integer) pValue);
                break;
            case "ctrnomaj":
            case "ctr_no_maj":
                pInstanceFormatUnique.setCtrNoMaj((String) pValue);
                break;
            case "ctrnoorigin":
            case "ctr_no_origin":
                pInstanceFormatUnique.setCtrNoOrigin((String) pValue);
                break;
            //*****************************
            case "idtrt":
            case "id_trt":
                pInstanceFormatUnique.setIdTrt((int) pValue);
                break;
            case "numligne":
            case "num_ligne":
                pInstanceFormatUnique.setNumLigne((int) pValue);
                break;
            case "idflxsrc":
            case "id_flx_src":
                pInstanceFormatUnique.setIdFlxSrc((int) pValue);
                break;
            case "numlignesrc":
            case "num_ligne_src":
                pInstanceFormatUnique.setNumLigneSrc((int) pValue);
                break;
            case "origflx":
            case "orig_flx":
                pInstanceFormatUnique.setOrigFlx((String) pValue);
                break;
            case "datacte":
            case "dat_acte":
                pInstanceFormatUnique.setDatActe(String.valueOf((Date) pValue));
                break;
            case "datcreatmvt":
            case "dat_creat_mvt":
                pInstanceFormatUnique.setDatCreatMvt ((LocalDate) pValue);
                break;
            case "dateffmvt":
            case "dat_eff_mvt":
                pInstanceFormatUnique.setDatEffMvt((LocalDate) pValue);
                break;
            case "ctrcdtarif":
            case "ctr_cd_tarif":
                pInstanceFormatUnique.setCtrCdTarif((String) pValue);
                break;
            case "ctrcateg":
            case "ctr_categ":
                pInstanceFormatUnique.setCtrCateg((String) pValue);
                break;
            case "ctrversiontarifcateg":
            case "ctr_version_tarif_categ":
                pInstanceFormatUnique.setCtrVersionTarifCateg((String) pValue);
                break;
            case "ctrdureepaiementmois":
            case "ctr_duree_paiement_mois":
                pInstanceFormatUnique.setCtrDureePaiementMois((Integer) pValue);
                break;
            case "ctr_dat_eff":
            case "ctrdateff":
                pInstanceFormatUnique.setCtrDatEff((LocalDate) pValue);
                break;
            case "ctr_dern_prime_payee":
            case "ctrdernprimepayee":
                pInstanceFormatUnique.setCtrDernPrimePayee((LocalDate) pValue);
                break;
            case "ctr_nb_primes_payees":
            case "ctrnbprimespayees":
                pInstanceFormatUnique.setCtrNbPrimesPayees((Integer) pValue);
                break;
            case "ctr_cd_nature_sortie":
            case "ctrcdnaturesortie":
                pInstanceFormatUnique.setCtrCdNatureSortie((String) pValue);
                break;
            case "ass_id_grc":
            case "assidgrc":
                pInstanceFormatUnique.setAssIdGrc((String) pValue);
                break;
            case "ass_nom":
            case "assnom":
                pInstanceFormatUnique.setAssNom((String) pValue);
                break;
            case "ass_nom_jeune_fille":
            case "assnomjeunefille":
                pInstanceFormatUnique.setAssNomJeuneFille((String) pValue);
                break;
            case "ass_prenom":
            case "assprenom":
                pInstanceFormatUnique.setAssPrenom((String) pValue);
                break;
            case "ass_age_a_souscr":
            case "assageasouscr":
                pInstanceFormatUnique.setAssAgeASouscr((Integer) pValue);
                break;
            case "ass_date_naiss":
            case "assdatenaiss":
                pInstanceFormatUnique.setAssDateNaiss((LocalDate) pValue);
                break;
            case "prod_matricule":
            case "prodmatricule":
                pInstanceFormatUnique.setProdMatricule((String) pValue);
                break;
            case "prod_cle_matricule":
            case "prodclematricule":
                pInstanceFormatUnique.setProdCleMatricule((String) pValue);
                break;
            case "prod_cd_geo_ctr_ou_prod":
            case "prodcdgeoctrouprod":
                pInstanceFormatUnique.setProdCdGeoCtrOuProd((String) pValue);
                break;
            case "mnt_id_aia_prime":
            case "mntidaiaprime":
                pInstanceFormatUnique.setMntIdAiaPrime((String) pValue);
                break;
            case "mnt_pp_ttc":
            case "mntppttc":
                pInstanceFormatUnique.setMntPpTtc((Double) pValue);
                break;
            case "mnt_pp_ht":
            case "mntppht":
                pInstanceFormatUnique.setMntPpHt((Double) pValue);
                break;
            case "mnt_dat_eff_prime":
            case "mntdateffprime":
                pInstanceFormatUnique.setMntDatEffPrime((LocalDate) pValue);
                break;
            case "mnt_tx_frais_pp":
            case "mnttxfraispp":
                pInstanceFormatUnique.setMntTxFraisPp((Double) pValue);
                break;
            case "mnt_respect_prec_opp":
            case "mntrespectprecopp":
                pInstanceFormatUnique.setMntRespectPrecoPp((String) pValue);
                break;
            case "mnt_pp_ttc_prec":
            case "mntppttcprec":
                pInstanceFormatUnique.setMntPpTtcPrec((Double) pValue);
                break;
            case "mnt_montant_vl":
            case "mntmontantvl":
                pInstanceFormatUnique.setMntMontantVl((Double) pValue);
                break;
            case "mnt_frais_vl":
            case "mntfraisvl":
                pInstanceFormatUnique.setMntFraisVl((Double) pValue);
                break;
            case "mnt_respect_preco_vl":
            case "mntrespectprecovl":
                pInstanceFormatUnique.setMntRespectPrecoVl((String) pValue);
                break;
            case "mnt_type_vers":
            case "mnttypevers":
                pInstanceFormatUnique.setMntTypeVers(String.valueOf(pValue));
                break;
            case "mnt_formule_gestion":
            case "mntformulegestion":
                pInstanceFormatUnique.setMntFormuleGestion((String) pValue);
                break;
            case "ctr_presence_de_garantie_de_prev":
            case "ctrpresencedegarantiedeprev":
                pInstanceFormatUnique.setCtrPresenceDeGarantieDePrev((String) pValue);
                break;
            case "ctr_motif_principal_avenant":
            case "ctrmotifprincipalavenant":
                pInstanceFormatUnique.setCtrMotifPrincipalAvenant((String) pValue);
                break;
            case "dt_crea":
            case "dtcrea":
                pInstanceFormatUnique.setDtCrea((LocalDateTime) pValue);
                break;
            case "dt_upd":
            case "dtupd":
                pInstanceFormatUnique.setDtUpd((LocalDateTime) pValue);
                break;
            case "statut":
                pInstanceFormatUnique.setStatut((String) pValue);
                break;
            default:
        }
    }
    public Object getValue(FormatUnique pInstanceFormatUnique, String pNomAttribut) {
        switch (pNomAttribut.toLowerCase()) {
            case "ctr_code_produit" :
            case "ctrcodeproduit" :
                return pInstanceFormatUnique.getCtrCodeProduit();
            case "ctr_no_propo" :
            case "ctrnopropo" :
                return pInstanceFormatUnique.getCtrNoPropo();
            case "cd_mvt" :
            case "cdMvt" :
                return pInstanceFormatUnique.getCdMvt();
            case "cd_lot" :
            case "cdlot" :
                return pInstanceFormatUnique.getCdLot();
            case "no_lot" :
            case "nolot" :
                return pInstanceFormatUnique.getNoLot();
            case "ctrdureemois":
            case "ctr_duree_mois":
                return pInstanceFormatUnique.getCtrDureeMois();
            case "ctrdureeannee":
            case "ctr_duree_annee":
                return pInstanceFormatUnique.getCtrDureeAnnee();
            case "ctrnomaj":
            case "ctr_no_maj":
                return pInstanceFormatUnique.getCtrNoMaj();
            case "ctrnoorigin":
            case "ctr_no_origin":
                return pInstanceFormatUnique.getCtrNoOrigin();
            //*****************************
            case "idtrt":
            case "id_trt":
                return pInstanceFormatUnique.getIdTrt();
            case "numligne":
            case "num_ligne":
                return pInstanceFormatUnique.getNumLigne();
            case "idflxsrc":
            case "id_flx_src":
                return pInstanceFormatUnique.getIdFlxSrc();
            case "numlignesrc":
            case "num_ligne_src":
                return pInstanceFormatUnique.getNumLigneSrc();
            case "origflx":
            case "orig_flx":
                return pInstanceFormatUnique.getOrigFlx();
            case "datacte":
            case "dat_acte":
                return pInstanceFormatUnique.getDatActe();
            case "datcreatmvt":
            case "dat_creat_mvt":
                return pInstanceFormatUnique.getDatCreatMvt ();
            case "dateffmvt":
            case "dat_eff_mvt":
                return pInstanceFormatUnique.getDatEffMvt();
            case "ctrcdtarif":
            case "ctr_cd_tarif":
                return pInstanceFormatUnique.getCtrCdTarif();
            case "ctrcateg":
            case "ctr_categ":
                return pInstanceFormatUnique.getCtrCateg();
            case "ctrversiontarifcateg":
            case "ctr_version_tarif_categ":
                return pInstanceFormatUnique.getCtrVersionTarifCateg();
            case "ctrdureepaiementmois":
            case "ctr_duree_paiement_mois":
                return pInstanceFormatUnique.getCtrDureePaiementMois();
            case "ctr_dat_eff":
            case "ctrdateff":
                return pInstanceFormatUnique.getCtrDatEff();
            case "ctr_dern_prime_payee":
            case "ctrdernprimepayee":
                return pInstanceFormatUnique.getCtrDernPrimePayee();
            case "ctr_nb_primes_payees":
            case "ctrnbprimespayees":
                return pInstanceFormatUnique.getCtrNbPrimesPayees();
            case "ctr_cd_nature_sortie":
            case "ctrcdnaturesortie":
                return pInstanceFormatUnique.getCtrCdNatureSortie();
            case "ass_id_grc":
            case "assidgrc":
                pInstanceFormatUnique.getAssIdGrc();
            case "ass_nom":
            case "assnom":
                return pInstanceFormatUnique.getAssNom();
            case "ass_nom_jeune_fille":
            case "assnomjeunefille":
                return pInstanceFormatUnique.getAssNomJeuneFille();
            case "ass_prenom":
            case "assprenom":
                return pInstanceFormatUnique.getAssPrenom();
            case "ass_age_a_souscr":
            case "assageasouscr":
                return pInstanceFormatUnique.getAssAgeASouscr();
            case "ass_date_naiss":
            case "assdatenaiss":
                return pInstanceFormatUnique.getAssDateNaiss();
            case "prod_matricule":
            case "prodmatricule":
                return pInstanceFormatUnique.getProdMatricule();
            case "prod_cle_matricule":
            case "prodclematricule":
                return pInstanceFormatUnique.getProdCleMatricule();
            case "prod_cd_geo_ctr_ou_prod":
            case "prodcdgeoctrouprod":
                return pInstanceFormatUnique.getProdCdGeoCtrOuProd();
            case "mnt_id_aia_prime":
            case "mntidaiaprime":
                return pInstanceFormatUnique.getMntIdAiaPrime();
            case "mnt_pp_ttc":
            case "mntppttc":
                return pInstanceFormatUnique.getMntPpTtc();
            case "mnt_pp_ht":
            case "mntppht":
                return pInstanceFormatUnique.getMntPpHt();
            case "mnt_dat_eff_prime":
            case "mntdateffprime":
                return pInstanceFormatUnique.getMntDatEffPrime();
            case "mnt_tx_frais_pp":
            case "mnttxfraispp":
                return pInstanceFormatUnique.getMntTxFraisPp();
            case "mnt_respect_prec_opp":
            case "mntrespectprecopp":
                return pInstanceFormatUnique.getMntRespectPrecoPp();
            case "mnt_pp_ttc_prec":
            case "mntppttcprec":
                return pInstanceFormatUnique.getMntPpTtcPrec();
            case "mnt_montant_vl":
            case "mntmontantvl":
                return pInstanceFormatUnique.getMntMontantVl();
            case "mnt_frais_vl":
            case "mntfraisvl":
                return pInstanceFormatUnique.getMntFraisVl();
            case "mnt_respect_preco_vl":
            case "mntrespectprecovl":
                return pInstanceFormatUnique.getMntRespectPrecoVl();
            case "mnt_type_vers":
            case "mnttypevers":
                return pInstanceFormatUnique.getMntTypeVers();
            case "mnt_formule_gestion":
            case "mntformulegestion":
                return pInstanceFormatUnique.getMntFormuleGestion();
            case "ctr_presence_de_garantie_de_prev":
            case "ctrpresencedegarantiedeprev":
                return pInstanceFormatUnique.getCtrPresenceDeGarantieDePrev();
            case "ctr_motif_principal_avenant":
            case "ctrmotifprincipalavenant":
                return pInstanceFormatUnique.getCtrMotifPrincipalAvenant();
            case "dt_crea":
            case "dtcrea":
                return pInstanceFormatUnique.getDtCrea();
            case "dt_upd":
            case "dtupd":
                return pInstanceFormatUnique.getDtUpd();
            case "statut":
                return pInstanceFormatUnique.getStatut();
            default:
                return null;
        }
    }*/
}
