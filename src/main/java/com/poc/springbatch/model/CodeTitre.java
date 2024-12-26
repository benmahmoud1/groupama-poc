package com.poc.springbatch.model;

// Enum pour le code titre personne
public enum CodeTitre {
    T1("1"),
    T2("2"),
    T3("3");

    private final String value;

    CodeTitre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
