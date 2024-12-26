package com.poc.springbatch.repository;

import com.poc.springbatch.model.StatutsMvt;
import com.poc.springbatch.model.StatutsMvtId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatutsMvtRepository extends JpaRepository<StatutsMvt, StatutsMvtId> {

    @Query(nativeQuery = true,value = "SELECT code_statut FROM t_statuts_mvt where code_bo =:codeBo")
    List<String> getcodeStatutsMvtByCodeBO(String codeBo);
}
