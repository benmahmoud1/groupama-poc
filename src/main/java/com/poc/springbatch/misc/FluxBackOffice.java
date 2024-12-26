package com.poc.springbatch.misc;

public enum FluxBackOffice {
    CREADMIN("CRE-ADMIN"),
    CRECOMPTA("CRE-COMPTA");

    private final String value;

    FluxBackOffice(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FluxBackOffice fromValue(String v) {
        for (FluxBackOffice c: FluxBackOffice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
