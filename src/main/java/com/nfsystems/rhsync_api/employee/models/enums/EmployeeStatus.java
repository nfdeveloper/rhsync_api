package com.nfsystems.rhsync_api.employee.models.enums;

public enum EmployeeStatus {
    WORKING("Trabalhando"),
    VACATION("Férias"),
    MEDICAL_CERTIFICATE("Atestado"),
    MEDICAL_CERTIFICATE_INSS("Atestado INSS"),
    MATERNITY_LEAVE("Licença Maternidade"),
    FAMILY_DEATH_LEAVE("Licença Morte Familiar"),
    EMPLOYEE_TERMINATED("Demitido"),
    EMPLOYEE_TERMINATED_JUST_CAUSE("Demitido Justa Causa");

    private final String value;

    EmployeeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
