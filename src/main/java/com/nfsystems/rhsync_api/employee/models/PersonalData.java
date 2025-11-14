package com.nfsystems.rhsync_api.employee.models;

import com.nfsystems.rhsync_api.employee.models.enums.MaritalStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Embeddable
public class PersonalData {

    @Column(name = "rhs_nm_empl", length = 120)
    private String name;

    @Column(name = "rhs_nknm_empl", length = 80)
    private String nickname;

    @Column(name = "rhs_dtbirth_empl")
    private LocalDate dateOfBirth;

    @Column(name = "rhs_cpf_empl", length = 11, unique = true)
    private String cpf;

    @Column(name = "rhs_rg_empl", length = 12, unique = true)
    private String rg;

    @Column(name = "rhs_ph_empl", length = 80)
    private String photo;

    @Column(name = "rhs_worcard_empl", length = 50, unique = true)
    private String workCard;

    @Column(name = "rhs_dadnm_empl", length = 120)
    private String fatherName;

    @Column(name = "rhs_momnm_empl", length = 120)
    private String motherName;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rhs_maritst_empl")
    private MaritalStatus maritalStatus;

    @Column(name = "rhs_wifnm_empl", length = 120)
    private String wifeName;

    @Column(name = "rhs_hvchil_empl")
    private Boolean haveChildrens;
}
