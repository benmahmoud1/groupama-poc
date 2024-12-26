package com.poc.springbatch;

import com.poc.springbatch.core.JexlFilterPredicate;
import com.poc.springbatch.model.ReglesValorisation;
import com.poc.springbatch.model.VwRivageCptGc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBatchApplicationDbsTests {
    @PersistenceContext
    EntityManager em;
    @Test
    void query() {
        var query = em.createNamedQuery("query.SEL_REGLE_VALO");
        query.setParameter("code_bo", "RIVAGE");
        List<ReglesValorisation> qry = query.getResultList();
        JexlFilterPredicate filter1 = new JexlFilterPredicate("regle", "regle.codeCas.equals('AFF-N-VI') || regle.codeCas.equals('*')" );
        Collection filteredQry = CollectionUtils.select( qry, filter1 );
        for (Object item : filteredQry) {
            System.out.println((ReglesValorisation) item);
        }

        JexlFilterPredicate filter2 = new JexlFilterPredicate("regle", "(regle.noSequence = 1) && (regle.codeCas.equals('AFF-N-VI') || regle.codeCas.equals('*'))" );
        Collection filteredFirstQry = CollectionUtils.select( qry, filter2 );
        for (Object item : filteredFirstQry) {
            System.out.println((ReglesValorisation) item);
        }
        /*
        var queryAdmin = em.createNamedQuery("query.CreAdminCharge");
        queryAdmin.setParameter("statut_flx", "CH");
        List<VwRivageAdminGc> qryAdmin = queryAdmin.getResultList();
        for (Object item : qryAdmin) {
            System.out.println((VwRivageAdminGc) item);
        }
        */
        var queryCompta = em.createNamedQuery("query.CreComptaCharge");
        queryCompta.setParameter("statut_flx", "CH");
        List<VwRivageCptGc> qryCompta = queryCompta.getResultList();
        for (Object item : qryCompta) {
            System.out.println((VwRivageCptGc) item);
        }
    }
}
