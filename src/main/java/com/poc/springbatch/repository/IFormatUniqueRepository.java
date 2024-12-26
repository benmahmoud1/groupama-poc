package com.poc.springbatch.repository;


import com.poc.springbatch.model.FormatUnique;
import com.poc.springbatch.model.FormatUniqueId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormatUniqueRepository extends JpaRepository<FormatUnique, FormatUniqueId> {
}
