package com.poc.springbatch;

import com.mysql.cj.Session;
import com.poc.springbatch.core.JexlFilterPredicate;
import com.poc.springbatch.core.ValorisationRivage;
import com.poc.springbatch.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.jexl3.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static com.poc.springbatch.misc.BackOffice.RIVAGE;
import static com.poc.springbatch.misc.FluxBackOffice.CREADMIN;
import static com.poc.springbatch.misc.FluxBackOffice.CRECOMPTA;

@SpringBootTest
@Slf4j
class SpringBatchApplicationValorisationTests {
    @PersistenceContext()
    EntityManager em;
    @Autowired
    PlatformTransactionManager transactionManager;

    void DoValorisation(long pIdTrt, long pNumeroLigne, ValorisationRivage itf, Collection pRegles) {
        JexlEngine jexl = new JexlBuilder().cache(512).strict(true).silent(false).create();

        FormatUnique fluxUnique = new FormatUnique();
        fluxUnique.setIdTrt(pIdTrt);
        fluxUnique.setNumLigne(pNumeroLigne);
        fluxUnique.setIdFlxSrc(itf.getRivageAdminGc().getIdFlx());
        fluxUnique.setNumLigneSrc(itf.getRivageAdminGc().getNumLigne());
        fluxUnique.setUserCrea("SYSTEM");
        fluxUnique.setStatut("EC");
        fluxUnique.setDtCrea((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        fluxUnique.setEtatMvt("AT"); // A Traité
        String ancienNomAttributFluxUnique = "";
        for (Object itemRegleValo : pRegles) {
            String expressionConditionValorisation =  ((ReglesValorisation) itemRegleValo).getConditionValoTechnique();
            String expressionValorisation =  ((ReglesValorisation) itemRegleValo).getExpressionValeurTechnique();

            JexlExpression eValo =  jexl.createExpression( expressionValorisation );
            // populate the context
            JexlContext contextValo = new MapContext();
            contextValo.set("itf", itf);
            contextValo.set("self", fluxUnique);
            boolean isOkConditionValorisation = false;
            if (expressionConditionValorisation != null && !"".equals(expressionConditionValorisation)) {
                JexlExpression eCondition =  jexl.createExpression( expressionConditionValorisation );
                JexlContext contextCondition = new MapContext();
                contextCondition.set("itf", itf);
                contextCondition.set("self", fluxUnique);
                isOkConditionValorisation = (Boolean) eCondition.evaluate(contextCondition);
            } else {
                isOkConditionValorisation = true;
            }

            if (!isOkConditionValorisation) continue;

            Object value = eValo.evaluate(contextValo);
            String nomAttributFluxUnique = ((ReglesValorisation) itemRegleValo).getNomChampFormatUnique();
            log.info(" ------> nomAttributFluxUnique : " + nomAttributFluxUnique + " " + value);
            try {
                itf.setValue(fluxUnique, nomAttributFluxUnique, value);
                // log.info("fluxUnique : " + fluxUnique);
                // On sort dès qu'on a réussi à valoriser l'attribut avec un critère en cas
                // de critères multiples
                if (itf.getValue(fluxUnique, nomAttributFluxUnique) != null &&
                        ancienNomAttributFluxUnique.equals(nomAttributFluxUnique)) {
                    continue;
                }
            } catch(Exception ex) {
                log.info("Exception : " + ex.getMessage());
            }
            ancienNomAttributFluxUnique = nomAttributFluxUnique;
        }
        // Persister l'objet flux Unique Instancié
        em.persist(fluxUnique);
        em.flush();
        log.info("----> em.persist(fluxUnique) ");
    }
    @Test

    void pocValorisation() {

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("valorisationFluxUnique");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);

        JexlEngine jexl = new JexlBuilder().cache(512).strict(true).silent(false).create();

        var qSel = em.createNamedQuery("query.SELECT_SEQUENCE_FLX");
        qSel.setParameter("code_rubrique", "SEQUENCE.INTEGRATION.IDTRAITEMENT");
        String sequenceString = (String) qSel.getSingleResult();
        long nextValue = Long.parseLong(sequenceString);
        nextValue = nextValue + 1;
        var qUpd = em.createNamedQuery("query.UPDATE_SEQUENCE_FLX");
        qUpd.setParameter("code_rubrique", "SEQUENCE.INTEGRATION.IDTRAITEMENT");
        qUpd.setParameter("valeur_rubrique", nextValue);

        int updatedSeq = qUpd.executeUpdate();
        if (updatedSeq > 0) {
            log.info("----> Resultat update sequence : " + updatedSeq);
        }
        //transactionManager.commit(status);

        var q = em.createNamedQuery("query.UPDATE_FORMAT_FIX_STATUT");

        /*------------------------------------------------
          DEBUT : A FAIRE HORS DE LA BOUCLE DE TRAITEMENT
         ------------------------------------------------*/
        // Lecture ordonancement de valorisation
        var queryOrdo = em.createNamedQuery("query.SEL_ORDO_VALO");
        queryOrdo.setParameter("code_bo", RIVAGE);
        queryOrdo.setParameter("actif", "O");
        List<CartoOrdonnancementValorisation> qryOrdos = queryOrdo.getResultList();
        // Lecture des règles de valorisation
        var queryRegle = em.createNamedQuery("query.SEL_REGLE_VALO");
        queryRegle.setParameter("code_bo", RIVAGE);
        List<ReglesValorisation> qryRegles = queryRegle.getResultList();

        System.out.println("regle.fluxMaitre.equals('" + CREADMIN.value() + "')");
        // Récupartion des régles de valorisation où le CREADMIN est le flux maître
        JexlFilterPredicate filterCreAdmin = new JexlFilterPredicate("regle", "regle.fluxMaitre.equals('" + CREADMIN.value() + "') || regle.fluxMaitre.equals('*')");
        Collection reglesCreAdmin = CollectionUtils.select(qryRegles, filterCreAdmin);

        // Récupartion des régles de valorisation où le CRECOMPTA est le flux maître
        JexlFilterPredicate filterCreCompta = new JexlFilterPredicate("regle", "regle.fluxMaitre.equals('" + CRECOMPTA.value() + "') || regle.fluxMaitre.equals('*')" );
        Collection reglesCreCompta = CollectionUtils.select( qryRegles, filterCreCompta );

        /*------------------------------------------------
          FIN : A FAIRE HORS DE LA BOUCLE DE TRAITEMENT
         ------------------------------------------------*/
        // Traitement des cas où le cre admin est maître
        var queryAdmin = em.createNamedQuery("query.SEL_ITEMS_CRE_ADMIN");
        queryAdmin.setParameter("statut_flx", "CH");
        List<ItemFlux> qryAdmin = queryAdmin.getResultList();
        long identifiantTraitement = nextValue;
        long numeroLigne = 1;
        for (ItemFlux item : qryAdmin) {

            // Instantiation de l'objet interface Rivage
            ValorisationRivage itf = new ValorisationRivage();
            itf.setEm(em);

            var queryAminGc = em.createNamedQuery("query.VwRivageAdminGc.list");
            queryAminGc.setParameter("cle_ident", item.getCleIdent());
            queryAminGc.setParameter("id_rappro", item.getIdRappro());
            List<VwRivageAdminGc> qryAdminGc = queryAminGc.getResultList();
            itf.setListRivageAdminGc(qryAdminGc);
            if (qryAdminGc.size() == 0) {
                throw new RuntimeException("VwRivageAdminGc non trouvé! ");
            }

            var queryAdmin9100 = em.createNamedQuery("query.VwRivageAdmin9100.list");
            queryAdmin9100.setParameter("cle_ident", item.getCleIdent());
            queryAdmin9100.setParameter("id_rappro", item.getIdRappro());
            List<VwRivageAdmin9100> qryAdmin9100 = queryAdmin9100.getResultList();
            itf.setListRivageAdmin9100(qryAdmin9100);
            if (qryAdmin9100.size() > 1) {
                System.out.println("VwRivageAdmin9100 non unique !");
                System.out.println("cle_ident : " + item.getCleIdent());
                System.out.println("id_rappro : " + item.getIdRappro());
            }
            var queryAdmin9200 = em.createNamedQuery("query.VwRivageAdmin9200.list");
            queryAdmin9200.setParameter("cle_ident", item.getCleIdent());
            queryAdmin9200.setParameter("id_rappro", item.getIdRappro());
            List<VwRivageAdmin9200> qryAdmin9200 = queryAdmin9200.getResultList();
            itf.setListRivageAdmin9200(qryAdmin9200);
            if (qryAdmin9200.size() > 1) {
                log.warn ("VwRivageAdmin9200 non unique !");
                log.warn ("cle_ident : " + item.getCleIdent());
                log.warn ("id_rappro : " + item.getIdRappro());
            }

            var queryComptaGc = em.createNamedQuery("query.VwRivageCptGc.list");
            queryComptaGc.setParameter("cle_ident", item.getCleIdent());
            queryComptaGc.setParameter("id_rappro", item.getIdRappro());
            List<VwRivageCptGc> qryComptaGc = queryComptaGc.getResultList();
            itf.setListRivageCptGc(qryComptaGc);
            if (qryComptaGc.size() > 1) {
                log.warn ("VwRivageCptGc non unique !");
                log.warn ("cle_ident : " + ((ItemFlux) item).getCleIdent());
                log.warn ("id_rappro : " + ((ItemFlux) item).getIdRappro());
            }
            var queryCompta0100 = em.createNamedQuery("query.VwRivageCptPrime0100.list");
            queryCompta0100.setParameter("cle_ident", item.getCleIdent());
            queryCompta0100.setParameter("id_rappro", item.getIdRappro());
            List<VwRivageCptPrime0100> qryCompta0100 = queryCompta0100.getResultList();
            itf.setListRivageCptPrime0100(qryCompta0100);
            if (qryCompta0100.size() > 1) {
                log.warn ("VwRivageCptPrime0100 non unique !");
                log.warn ("cle_ident : " + item.getCleIdent());
                log.warn ("id_rappro : " + item.getIdRappro());
            }

            var queryCompta0101 = em.createNamedQuery("query.VwRivageCptPrime0101.list");
            queryCompta0101.setParameter("cle_ident", item.getCleIdent());
            queryCompta0101.setParameter("id_rappro", item.getIdRappro());
            List<VwRivageCptPrime0101> qryCompta0101 = queryCompta0101.getResultList();
            itf.setListRivageCptPrime0101(qryCompta0101);
            if (qryCompta0101.size() > 1) {
                log.warn ("VwRivageCptPrime0101 non unique !");
                log.warn ("cle_ident : " + item.getCleIdent());
                log.warn ("id_rappro : " + item.getIdRappro());
            }

            //em.getTransaction().begin();
            // Tentative de valorisation en fonction des critères
            for (CartoOrdonnancementValorisation ordo : qryOrdos) {
                JexlFilterPredicate filterRegleCasPrincipal = new JexlFilterPredicate("regle", "regle.codeCas.equals('"+ ordo.getCodeCasPrinc() + "') || regle.codeCas.equals('*')" );
                Collection reglesCreAdminCasPrincipal = CollectionUtils.select( reglesCreAdmin, filterRegleCasPrincipal );

                JexlFilterPredicate filterRegleCasSecondaire = new JexlFilterPredicate("regle", "regle.codeCas.equals('"+ ordo.getCodeCasSecond() + "') || regle.codeCas.equals('*')" );
                Collection reglesCreAdminCasSecondaire = CollectionUtils.select( reglesCreAdmin, filterRegleCasSecondaire );

                JexlFilterPredicate filterReglesPremiereSequencePrinc = new JexlFilterPredicate("regle", "(regle.noSequence == 1)" );
                Collection reglesPremiereSequencePrinc = CollectionUtils.select( reglesCreAdminCasPrincipal, filterReglesPremiereSequencePrinc );

                JexlFilterPredicate filterReglesPremiereSequenceSecond = new JexlFilterPredicate("regle", "(regle.noSequence == 1)" );
                Collection reglesPremiereSequenceSecond = CollectionUtils.select( reglesCreAdminCasSecondaire, filterReglesPremiereSequenceSecond );

                String critereInstantiationPrincipal = null;
                if (!reglesPremiereSequencePrinc.isEmpty()) {
                    critereInstantiationPrincipal = ((ReglesValorisation) ((List) reglesPremiereSequencePrinc).get(0)).getConditionValoTechnique();
                };
                String critereInstantiationSecondaire = null;
                if (!reglesPremiereSequenceSecond.isEmpty()) {
                    critereInstantiationSecondaire = ((ReglesValorisation) ((List) reglesPremiereSequenceSecond).get(0)).getConditionValoTechnique();
                };
                if (critereInstantiationPrincipal == null) continue;
                JexlExpression e =  jexl.createExpression( critereInstantiationPrincipal );
                // populate the context
                JexlContext context = new MapContext();
                context.set("itf", itf);
                boolean instanceFluxUniqueCasPrincipal = (Boolean) e.evaluate(context);
                boolean instanceFluxUniqueCasSecond = false;
                if (critereInstantiationSecondaire != null) {
                    JexlExpression eSec =  jexl.createExpression( critereInstantiationSecondaire );
                    // populate the context
                    JexlContext contextSec = new MapContext();
                    contextSec.set("itf", itf);
                    instanceFluxUniqueCasSecond = (Boolean) eSec.evaluate(contextSec);
                }
                if (instanceFluxUniqueCasPrincipal) {
                    log.info("----> Condition principale vérifiée : getCleIdent : " + item.getCleIdent() +
                         " id_rappro : " + item.getIdRappro());
                    this.DoValorisation(identifiantTraitement, numeroLigne, itf, reglesCreAdminCasPrincipal);
                    numeroLigne++;
                    if (instanceFluxUniqueCasSecond) {
                        log.info("----> Condition secondaire vérifiée : getCleIdent : " + item.getCleIdent() +
                                " id_rappro : " + item.getIdRappro());
                        this.DoValorisation(identifiantTraitement, numeroLigne, itf, reglesCreAdminCasSecondaire);
                        numeroLigne++;
                    }
                    // On sort dès que le premier critère de valorisation est vérifié et traité
                    break;
                } else {
                    log.info("----> Condition non vérifiée !!! ");
                }
                // Evaluation
            }

            q.setParameter("statut_flx","TR");
            q.setParameter("cle_ident", item.getCleIdent());
            q.setParameter("id_rappro", item.getIdRappro());

            int updated = q.executeUpdate();
            if (updated > 0) {
                log.info("----> Nombre mis à jour : " + updated);
            }
        }
        transactionManager.commit(status);
    }
}
