package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_titre_personne")
public class TitrePersonne {

    @Id
    @Column(name = "code_titre", length = 1)
    private String codeTitre;

    @Column(name = "lib_titre", length = 90, nullable = false)
    private String libTitre;         // Libellé titre personne


}
