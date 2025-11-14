package com.nfsystems.rhsync_api.company.models;

import com.nfsystems.rhsync_api.common.models.Address;
import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.common.models.Contact;
import com.nfsystems.rhsync_api.group.models.Group;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rhs_comp",
        indexes = {
                @Index(name = "comp_idx_cnpj", columnList = "rhs_comp_cnpj", unique = true)
        })
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_comp")
    private Long id;

    @Embedded
    private CompanyData companyData;

    @Column(name = "rhs_par_comp")
    private Boolean parentCompany;

    @Embedded
    private Contact contact;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "cvs_seq_group")
    private Group group;
}
