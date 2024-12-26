package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class FluxId implements Serializable {

    @Column(name = "id_flx", nullable = false)
    private Integer idFlx;


    @Column(name = "num_ligne", nullable = false)
    private Integer numLigne;
}
