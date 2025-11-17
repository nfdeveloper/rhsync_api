package com.nfsystems.rhsync_api.marking.models.enums;

public enum SolicitationStatus {
    CREATED("Criado"),
    APPROVED("Aprovado"),
    REJECTED("Rejeitado");

    private String value;

    private SolicitationStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
