package com.nfsystems.rhsync_api.company.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Embeddable
public class CompanyData {

    @Column(name = "rhs_comp_socra",length = 100)
    private String socialRationale;

    @Column(name = "rhs_comp_fn",length = 100)
    private String fantasyName;

    @Column(name = "rhs_comp_sr",length = 50)
    private String stateRegistration;

    @Column(name = "rhs_comp_cnpj",length = 20, unique = true)
    private String cnpj;

    @Column(name = "rhs_comp_wq")
    private Long workingQuantity;

    @Column(name = "rhs_comp_sda")
    private LocalDate startDateActivity;
}
