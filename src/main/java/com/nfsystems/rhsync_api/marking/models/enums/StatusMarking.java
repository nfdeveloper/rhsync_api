package com.nfsystems.rhsync_api.marking.models.enums;

public enum StatusMarking {
    ANALIZING("Analizando"),
    APPROVED("Aprovado"),
    REPPROVED("Não Aprovado");

    private String value;

    StatusMarking(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
