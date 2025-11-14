package com.nfsystems.rhsync_api.common.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(name = "rhs_adr_cep", length = 10)
    private String cep;

    @Column(name = "rhs_adr_est", length = 80)
    private String state;

    @Column(name = "rhs_adr_cid", length = 80)
    private String city;

    @Column(name = "rhs_adr_bair", length = 80)
    private String neighborhood;

    @Column(name = "rhs_adr_rua", length = 100)
    private String street;

    @Column(name = "rhs_adr_num", length = 20)
    private String number;

    @Column(name = "rhs_adr_comp", length = 20)
    private String complement;
}
