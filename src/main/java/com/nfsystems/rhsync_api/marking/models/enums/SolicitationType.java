package com.nfsystems.rhsync_api.marking.models.enums;

public enum SolicitationType {
    INCLUSION("Inclusão"),
    CHANGE("Alteração"),
    DELETION("Exclusão");

    private String value;

    private SolicitationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
