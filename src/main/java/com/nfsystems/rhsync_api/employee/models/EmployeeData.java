package com.nfsystems.rhsync_api.employee.models;

import com.nfsystems.rhsync_api.employee.models.enums.EmployeeStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Embeddable
public class EmployeeData {

    @Column(name = "rhs_dtadm_empl")
    private LocalDate admissionDate;

    @Column(name = "rhs_dtdem_empl")
    private LocalDate demissionDate;

    @Column(name = "rhs_reasdem_empl", length = 300)
    private String reasonDemission;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rhs_st_empl")
    private EmployeeStatus employeeStatus;

    @Column(name = "rhs_sal_empl", precision = 16, scale = 2)
    private BigDecimal salary;

    @Column(name = "rhs_addsal_empl", precision = 16, scale = 2)
    private BigDecimal additionalSalary;

    @Column(name = "rhs_istransvou_empl")
    private Boolean isTransportationVoucher;

    @Column(name = "rhs_transvou_empl", precision = 16, scale = 2)
    private BigDecimal transportationVoucher;

    @Column(name = "rhs_corpem_empl", length = 80)
    private String corporateEmail;
}
