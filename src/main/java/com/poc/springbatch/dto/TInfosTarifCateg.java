package com.poc.springbatch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data  @NoArgsConstructor @AllArgsConstructor @ToString
public class TInfosTarifCateg {
    private String tarif;
    private String categorie;
    private String version;
}
