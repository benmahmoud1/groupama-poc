package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ParamComposantFluxId implements Serializable {

    @Column(name = "id_flux", nullable = false)
    private Long idFlux;

    @Column(name = "id_cmp_flux", nullable = false)
    private Long idCmpFlux;
}
