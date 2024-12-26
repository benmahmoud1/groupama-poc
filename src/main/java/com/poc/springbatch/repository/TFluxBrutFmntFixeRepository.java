package com.poc.springbatch.repository;


import com.poc.springbatch.model.FluxId;
import com.poc.springbatch.model.TFluxBrutFmntFixe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TFluxBrutFmntFixeRepository extends JpaRepository<TFluxBrutFmntFixe, FluxId> {
}
