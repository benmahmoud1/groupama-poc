package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "t_centre_de_profit")
public class CentreDeProfit {

    @Id
    @Column(name = "code_ctre_prof", nullable = false, length = 30)
    private String codeCtreProf;

    @Column(name = "lib_ctre_prof", nullable = false, length = 255)
    private String libCtreProf;


}
