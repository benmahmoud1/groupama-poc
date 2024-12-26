package com.poc.springbatch.repository;

import com.poc.springbatch.model.ActesGestion;
import com.poc.springbatch.model.ActesGestionId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActesGestionRepository extends JpaRepository<ActesGestion, ActesGestionId> {

       @Query(nativeQuery = true,value = "SELECT code_acte FROM t_actes_gestion where code_bo =:codeBo")
       List<String> getcodeActeByCodeBO(String codeBo);
}
