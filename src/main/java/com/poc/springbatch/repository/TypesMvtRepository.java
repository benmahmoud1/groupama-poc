package com.poc.springbatch.repository;

import com.poc.springbatch.model.TypesMvt;
import com.poc.springbatch.model.TypesMvtId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypesMvtRepository extends JpaRepository<TypesMvt, TypesMvtId> {

    @Query(nativeQuery = true,value = "SELECT code_type_mvt FROM t_types_mvt where code_bo =:codeBo")
    List<String> getcodeTypeMvtByCodeBO(String codeBo);
}
