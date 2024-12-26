package com.poc.springbatch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data  @NoArgsConstructor @AllArgsConstructor @ToString
public class ItemFlux {
    private long idFlx;
    private String cleIdent;
    private String idRappro;
}
