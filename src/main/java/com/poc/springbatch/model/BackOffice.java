package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_back_office")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BackOffice {

    @Id
    @Column(name = "code_bo", nullable = false, length = 90)
    private String codeBo;

    @Column(name = "desc_bo", length = 150)
    private String descBo;


}