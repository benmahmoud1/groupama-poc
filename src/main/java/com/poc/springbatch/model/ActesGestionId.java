package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ActesGestionId {

    @Column(name = "code_acte", length = 90)
    private String codeActe;

    @Column(name = "code_bo", length = 90)
    private String codeBo;
}
