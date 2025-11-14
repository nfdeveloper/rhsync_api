package com.nfsystems.rhsync_api.employee.models.enums;

public enum MaritalStatus {
    SINGLE("Solteiro"),
    MARRIED("Casado"),
    DIVORCED("Divorciado"),
    WIDOWED("Viúvo");

    private final String value;

    MaritalStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
