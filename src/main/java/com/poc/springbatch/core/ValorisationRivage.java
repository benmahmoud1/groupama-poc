package com.poc.springbatch.core;

import com.poc.springbatch.dto.TInfosFormule;
import com.poc.springbatch.dto.TInfosTarifCateg;
import com.poc.springbatch.misc.UtilsTools;
import com.poc.springbatch.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.*;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.poc.springbatch.misc.UtilsTools.*;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Component
public class ValorisationRivage extends ValorisationFormatUnique {

    EntityManager em;
    private List<VwRivageAdminGc> listRivageAdminGc;
    private List<VwRivageAdmin9100> listRivageAdmin9100;

    //Vw_rivage_admin_9110 rivageAdmin9110;
    //Vw_rivage_admin_9130 rivageAdmin9130;
    private List<VwRivageAdmin9200> listRivageAdmin9200;
    private List<VwRivageCptGc> listRivageCptGc;

    private List<VwRivageCptPrime0100> listRivageCptPrime0100;
    private List<VwRivageCptPrime0101> listRivageCptPrime0101;
    //Vw_rivage_cpt_0300 rivageCpt0300;
    //Vw_rivage_cpt_2000 rivageCpt2000;

    public VwRivageAdminGc getRivageAdminGc() {
       if (listRivageAdminGc != null && !listRivageAdminGc.isEmpty()) {
           return listRivageAdminGc.get(0);
       }
       return  null;
    }
    public VwRivageAdmin9100 getRivageAdmin9100() {
        if (listRivageAdmin9100 != null && !listRivageAdmin9100.isEmpty()) {
            return listRivageAdmin9100.get(0);
        }
        return  null;
    }

    public VwRivageAdmin9200 getRivageAdmin9200() {
        if (listRivageAdmin9200 != null && !listRivageAdmin9200.isEmpty()) {
            return listRivageAdmin9200.get(0);
        }
        return  null;
    }
    public VwRivageCptGc getRivageCptGc() {
        if (listRivageCptGc != null && !listRivageCptGc.isEmpty()) {
            return listRivageCptGc.get(0);
        }
        return  null;
    }
    public VwRivageCptPrime0100 getRivageCptPrime0100() {
        if (listRivageCptPrime0100 != null && !listRivageCptPrime0100.isEmpty()) {
            return listRivageCptPrime0100.get(0);
        }
        return  null;
    }
    public VwRivageCptPrime0101 getRivageCptPrime0101() {
        if (listRivageCptPrime0101 != null && !listRivageCptPrime0101.isEmpty()) {
            return listRivageCptPrime0101.get(0);
        }
        return  null;
    }

    @Override
    public boolean isValidCodeMouvement(String codeMvt) {
        switch (codeMvt) {
            case "V103" -> {
                ArrayList<String> codeActesPart = new ArrayList<>(Arrays.asList("vldtprpsn".toUpperCase(),
                        "AUTO_PROP_TRSNFR".toUpperCase(),
                        "NB".toUpperCase()));
                ArrayList<String> typeMouvements = new ArrayList<>(Arrays.asList("initial".toUpperCase(),
                        "trnsfr_in".toUpperCase(),
                        "_xtrnsfr".toUpperCase(),
                        "sngl_1".toUpperCase(),
                        "_itrnsfr".toUpperCase()));
                ArrayList<String> statusMouvements = new ArrayList<>(Arrays.asList("paid_o_bal".toUpperCase(),
                        "create_paid".toUpperCase()));
                return codeActesPart.contains(this.getRivageAdminGc().getCodeActeDeGestion().toUpperCase()) &&
                        typeMouvements.contains(this.getRivageCptGc().getTypeDuMouvement().toUpperCase())  &&
                        statusMouvements.contains(this.getRivageCptGc().getStatusMouvement().toUpperCase());
            }
            case "E103" -> {
                ArrayList<String> codeActes = new ArrayList<>(Arrays.asList("vldtprpsn".toUpperCase(),
                        "AUTO_PROP_TRSNFR".toUpperCase(),
                        "NB".toUpperCase()));
                return codeActes.contains(this.getRivageAdminGc().getCodeActeDeGestion().toUpperCase());
            }
            default -> {
                return false;
            }
        }
    }


    @Override
    public String cdLot() {
        return this.getRivageAdminGc().getCodeLot();
    }

    @Override
    public String noLot() {
        return this.getRivageAdminGc().getNoLotExtractionCsc();
    }

    @Override
    public LocalDateTime datActe()  {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATETIME);
        return LocalDateTime.parse(this.getRivageAdminGc().getTimestampDeLAg() , dtformatter);
    }
    @Override
    public LocalDate datCreatMvt() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        return LocalDate.parse(this.getRivageAdminGc().getDateOperation() , dtformatter);
    }

    @Override
    public LocalDate datEffMvt() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        return LocalDate.parse(this.getRivageAdminGc().getDateEffetDuMvt() , dtformatter);
    }

    @Override
    public String ctrNoMaj() {
        return this.getRivageAdminGc().getContrat().substring(2, 11);
    }

    @Override
    public String ctrNoOrigin() {
        return this.getRivageAdminGc().getContrat();
    }

    @Override
    public String ctrCdTarif() {
        var qryTarifCategs = em.createNamedQuery("query.SELECT_TARIF_CATEG");
        qryTarifCategs.setParameter("cle_ident", this.getRivageAdminGc().getCleIdent());
        qryTarifCategs.setParameter("id_rappro", this.getRivageAdminGc().getIdRappro());
        qryTarifCategs.setParameter("id_flx", this.getRivageAdminGc().getIdFlx());
        List<TInfosTarifCateg> listTarifCategs = qryTarifCategs.getResultList();
        if (!listTarifCategs.isEmpty()) {
            return ((TInfosTarifCateg) listTarifCategs.get(0)).getTarif();
        }
        return null;
    }

    @Override
    public String ctrCateg() {
        var qryTarifCategs = em.createNamedQuery("query.SELECT_TARIF_CATEG");
        qryTarifCategs.setParameter("cle_ident", this.getRivageAdminGc().getCleIdent());
        qryTarifCategs.setParameter("id_rappro", this.getRivageAdminGc().getIdRappro());
        qryTarifCategs.setParameter("id_flx", this.getRivageAdminGc().getIdFlx());
        List<TInfosTarifCateg> listTarifCategs = qryTarifCategs.getResultList();
        if (!listTarifCategs.isEmpty()) {
            return ((TInfosTarifCateg) listTarifCategs.get(0)).getCategorie();
        }
        return null;
    }

    @Override
    public String ctrVersionTarifCateg() {
        var qryTarifCategs = em.createNamedQuery("query.SELECT_TARIF_CATEG");
        qryTarifCategs.setParameter("cle_ident", this.getRivageAdminGc().getCleIdent());
        qryTarifCategs.setParameter("id_rappro", this.getRivageAdminGc().getIdRappro());
        qryTarifCategs.setParameter("id_flx", this.getRivageAdminGc().getIdFlx());
        List<TInfosTarifCateg> listTarifCategs = qryTarifCategs.getResultList();
        if (!listTarifCategs.isEmpty()) {
            return ((TInfosTarifCateg) listTarifCategs.get(0)).getVersion();
        }
        return null;
    }

    @Override
    public Integer ctrDureeMois() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        if (LocalDate.parse(this.getRivageAdmin9100().getDateTermeDuContrat() , dtformatter).getYear() == 9999 ||
                LocalDate.parse(this.getRivageAdminGc().getDateEffetDuContrat() , dtformatter).getYear() == 9999) {
            return 999;
        }
        return (int) ChronoUnit.MONTHS.between(LocalDate.parse(this.getRivageAdminGc().getDateEffetDuContrat() , dtformatter),
                LocalDate.parse(this.getRivageAdmin9100().getDateTermeDuContrat() , dtformatter).plusDays(1));
    }

    @Override
    public Integer ctrDureeAnnee() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        if (LocalDate.parse(this.getRivageAdmin9100().getDateTermeDuContrat() , dtformatter).getYear() == 9999 ||
                LocalDate.parse(this.getRivageAdminGc().getDateEffetDuContrat() , dtformatter).getYear() == 9999) {
            return 99;
        }
        return (int) ChronoUnit.YEARS.between(LocalDate.parse(this.getRivageAdminGc().getDateEffetDuContrat() , dtformatter),
                LocalDate.parse(this.getRivageAdmin9100().getDateTermeDuContrat() , dtformatter).plusDays(1));
    }

    @Override
    public LocalDate ctrDernPrimePayee() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        if (this.getRivageAdminGc() != null) {
            return LocalDate.parse(this.getRivageAdminGc().getDateDernierePrimePayee(), dtformatter);
        } else {
            return null;
        }

    }
    @Override
    public Integer ctrDureePaiementMois() {
        if (this.getRivageAdmin9200() != null) {
            //log.info("****************************** : " + this.getRivageAdmin9200().getDureeDuPaiementEnMois());
            return Integer.parseInt(this.getRivageAdmin9200().getDureeDuPaiementEnMois());
        } else {
            return null;
        }
    }

    @Override
    public Double mntPpTtc() {
        if (this.getRivageAdmin9200() != null) {
            return UtilsTools.rivageStringToDecimal(this.getRivageAdmin9200().getMontantPrimeCommercialeAnnuelleTtc())/12;
        } else {
            return null;
        }
    }

    @Override
    public Double mntPpHt() {
        if (this.getRivageAdmin9200() != null) {
            return UtilsTools.rivageStringToDecimal(this.getRivageAdmin9200().getMontantPrimeCommercialeAnnuelleHt())/12;
        } else {
            return null;
        }
    }

    @Override
    public Double mntTxFraisPp() {
        if (this.getRivageAdmin9200() != null) {
            return UtilsTools.rivageStringToDecimal(this.getRivageAdmin9200().getTauxDeFraisPpOuVlp());
        } else {
            return null;
        }
    }
    @Override
    public LocalDate mntDatEffPrime() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        if (this.getRivageAdmin9200() != null) {
            return LocalDate.parse(this.getRivageAdmin9200().getDateEffetProchPrelevt(), dtformatter);
        }
        return null;
    }
    @Override
    public LocalDate ctrDatEff() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        return LocalDate.parse(this.getRivageAdminGc().getDateEffetDuContrat(), dtformatter);
    }

    @Override
    public String ctrNoPropo() {
       return this.getRivageAdmin9100().getNoProposition();
    }

    @Override
    public String assIdGrc() {
        return StringUtils.right(this.getRivageAdmin9100().getIdGrcAssurePrincipal(), 8);
    }

    @Override
    public String assNom() {
        return this.getRivageAdmin9100().getNomDeLAssurePrincipal();
    }

    @Override
    public String assNomJeuneFille() {
        return this.getRivageAdmin9100().getNomDeJeuneFilleDeLAssure();
    }

    @Override
    public String assPrenom() {
        return this.getRivageAdmin9100().getPrenomDeLAssurePrincipal();
    }

    @Override
    public String prodMatricule() {
        String structureCom = (StringUtils.isAllBlank(this.getRivageAdminGc().getNiveau1StructureCommerciale()) ?
                this.getRivageAdminGc().getNiveau2StructureCommerciale() :
                this.getRivageAdminGc().getNiveau1StructureCommerciale());
        if (!StringUtils.isAllBlank(structureCom)) {
            return StringUtils.substring(structureCom, 0, structureCom.length() - 1);
        } else {
            return null;
        }
    }

    @Override
    public String prodCleMatricule() {
        String structureCom = (StringUtils.isAllBlank(this.getRivageAdminGc().getNiveau1StructureCommerciale()) ?
                this.getRivageAdminGc().getNiveau2StructureCommerciale() :
                this.getRivageAdminGc().getNiveau1StructureCommerciale());
        if (!StringUtils.isAllBlank(structureCom)) {
            return StringUtils.right(structureCom,  1);
        } else {
            return null;
        }
    }

    @Override
    public String prodCdGeoCtrOuProd() {
        /*
            RG10_1_Code géographique
        */
        String value = this.getRivageAdminGc().getCodeGeographiqueGanPrevoyance();
        value = value.substring(0, 8);
        return value.substring(2, 2 + 2) + value.substring(5, 5 + 1) + value.substring(7, 7 + 1);
    }

    @Override
    public String mntIdAiaPrime() {
        return this.getRivageAdminGc().getNoDuMouvemeInterneAiaPrimePrestatArbitraSnppEt();
    }

    @Override
    public Double mntMontantVl() {
        ArrayList<String> elementsTechnique = new ArrayList<>(Arrays.asList("C.ADH", "D.ENTREE"));
        var valeurSoustraite =0.0;
        if (this.getRivageCptPrime0101() != null && this.getRivageCptPrime0101().getElementTechnique() != null) {
            valeurSoustraite = elementsTechnique.contains(this.getRivageCptPrime0101().getElementTechnique()) ?
                    UtilsTools.rivageStringToDecimal(this.getRivageCptPrime0101().getMontantFrais()): 0;
        }
        try {
            return UtilsTools.rivageStringToDecimal(this.getRivageCptPrime0100().getMtPrimePure()) +
                    UtilsTools.rivageStringToDecimal(this.getRivageCptPrime0100().getMtTotalDesChargements()) - valeurSoustraite;
        } catch(Exception ex) {
            return null;
        }
    }

    @Override
    public LocalDate mntDatEffVl() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        try {
            return LocalDate.parse(this.getRivageCptPrime0100().getDateDebutEffetPrime(), dtformatter);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Double mntFraisVl() {
        ArrayList<String> elementsTechnique = new ArrayList<>(Arrays.asList("C.ADH", "D.ENTREE"));
        var valeurFrais =0.0;
        if (this.getRivageCptPrime0101() != null && this.getRivageCptPrime0101().getElementTechnique() != null) {
            valeurFrais = elementsTechnique.contains(this.getRivageCptPrime0101().getElementTechnique()) ?
                    UtilsTools.rivageStringToDecimal(this.getRivageCptPrime0101().getMontantFrais()): 0;
        }
        try {
            return valeurFrais / (this.mntMontantVl() * 100);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public boolean isValidRespectPrecoVl() {
        return true;
    }

    @Override
    public String mntRespectPrecoVl() {
        if (this.getRivageCptPrime0100() != null) {
            this.getRivageCptPrime0100().getTopPreconisation();
        }
        return null;
    }

    @Override
    public String mntRespectPrecoPp(){
        if (this.getRivageAdmin9200() != null) {
            this.getRivageAdmin9200().getTopPreconisation();
        }
        return null;
    }
    @Override
    public boolean isValidTypeVers(String typeversement) {
        ArrayList<String> canaux;
        ArrayList<String> type_du_mouvements;
        ArrayList<String> origines_du_versement;

        switch (typeversement) {
            case "5" -> {
                canaux = new ArrayList<>(Arrays.asList("internet", "digital", "espcli"));
                return canaux.contains(this.getRivageAdminGc().getCanal().toLowerCase());
            }
            case "4" -> {
                type_du_mouvements = new ArrayList<>(Arrays.asList("trnsfr_in", "_xtrnsfr", "_itrnsfr"));
                return type_du_mouvements.contains(this.getRivageCptGc().getTypeDuMouvement()) &&
                        "no".equals(this.getRivageCptPrime0100().getIndicateurRepriseALaConcurrence().toLowerCase());
            }
            case "3" -> {
                type_du_mouvements = new ArrayList<>(Arrays.asList("trnsfr_in", "_xtrnsfr"));
                return type_du_mouvements.contains(this.getRivageCptGc().getTypeDuMouvement()) &&
                        "yes".equals(this.getRivageCptPrime0100().getIndicateurRepriseALaConcurrence().toLowerCase());
            }
            case "2" -> {
                type_du_mouvements = new ArrayList<>(Arrays.asList("unslctd", "initial"));
                origines_du_versement = new ArrayList<>(Arrays.asList("intrnl", "extrnl"));
                return type_du_mouvements.contains(this.getRivageCptGc().getTypeDuMouvement()) &&
                        origines_du_versement.contains(this.getRivageCptPrime0100().getOrigineDuVersement());
            }
            case "1" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public boolean isValidFormuleGestion(String formulegestion) {
        ArrayList<String> specificProducts;
        switch (formulegestion) {
            case "03" -> {
                specificProducts = new ArrayList<>(Arrays.asList("3RUC7W00", "3RAV7U00", "3PERINDV", "3PER7C00"));
                return specificProducts.contains(this.getRivageAdminGc().getCodeProduit());
            }
            case "01" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public boolean existsReferenceFormuleGestion() {
        var qryFormule = em.createNamedQuery("query.SELECT_FORMULE");
        qryFormule.setParameter("cle_ident", this.getRivageAdminGc().getCleIdent());
        qryFormule.setParameter("id_rappro", this.getRivageAdminGc().getIdRappro());
        qryFormule.setParameter("id_flx", this.getRivageAdminGc().getIdFlx());
        List<TInfosFormule> listFormules = qryFormule.getResultList();
        if (!listFormules.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String ctrCodeProduit() {
        return this.getRivageAdminGc().getCodeProduit();
    }
    @Override
    public Integer assAgeASouscr() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        if (LocalDate.parse(this.getRivageAdminGc().getDateEffetDuContrat() , dtformatter).getYear() == 9999) {
            return 99;
        }
        try {
            return (int) ChronoUnit.YEARS.between(LocalDate.parse(this.getRivageAdmin9100().getDateDeNaissanceDeLAssurePrincipal(), dtformatter),
                    LocalDate.parse(this.getRivageAdminGc().getDateEffetDuContrat(), dtformatter).plusDays(1));
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public LocalDate assDateNaiss() {
        var dtformatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        try {
            return LocalDate.parse(this.getRivageAdmin9100 ().getDateDeNaissanceDeLAssurePrincipal(), dtformatter);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public boolean isSetFormuleGestion() {
        return false;
    }

    @Override
    public String referenceFormuleGestion() {
        var qryFormule = em.createNamedQuery("query.SELECT_FORMULE");
        qryFormule.setParameter("cle_ident", this.getRivageAdminGc().getCleIdent());
        qryFormule.setParameter("id_rappro", this.getRivageAdminGc().getIdRappro());
        qryFormule.setParameter("id_flx", this.getRivageAdminGc().getIdFlx());
        List<TInfosFormule> listFormules = qryFormule.getResultList();
        //log.info("******************** : " + listFormules);
        if (!listFormules.isEmpty()) {
            return ((TInfosFormule) listFormules.get(0)).getCodeFormule();
        }
        return null;
    }

    @Override
    public String ctrPresenceDeGarantieDePrev() {
        var qryFormule = em.createNamedQuery("query.SELECT_PRESENCE_PREV");
        qryFormule.setParameter("cle_ident", this.getRivageAdminGc().getCleIdent());
        qryFormule.setParameter("id_rappro", this.getRivageAdminGc().getIdRappro());
        qryFormule.setParameter("id_flx", this.getRivageAdminGc().getIdFlx());
        Integer value = qryFormule.getFirstResult();
        if (value != null) {
            value = 0;
        }
        log.info("**************** : " + value);
        if (value > 0) {
            return "O";
        }
        return "N";
    }

    @Override
    public String ctrMotifPrincipalAvenant() {
        return null;
    }
}
