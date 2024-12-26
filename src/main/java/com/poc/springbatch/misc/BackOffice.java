package com.poc.springbatch.misc;

public enum BackOffice {
    RIVAGE("RIVAGE"),
    GANPREV("GANPREV"),
    ALPTIS("ALPTIS"),
    PJ("PJ"),
    EXPERTISIMO("EXPERTISIMO"),
    GES("GES"),
    COLLECTIVES("COLLECTIVES");

    private final String value;

    BackOffice(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BackOffice fromValue(String v) {
        for (BackOffice c: BackOffice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
