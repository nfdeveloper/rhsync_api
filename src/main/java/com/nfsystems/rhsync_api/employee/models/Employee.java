package com.nfsystems.rhsync_api.employee.models;

import com.nfsystems.rhsync_api.common.models.Address;
import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.common.models.Contact;
import com.nfsystems.rhsync_api.company.models.Company;
import com.nfsystems.rhsync_api.jobfunction.models.JobFunction;
import com.nfsystems.rhsync_api.sector.models.Sector;
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
@Table(
        name = "rhs_empl",
        indexes = {
                @Index(name = "empl_idx_cpf", columnList = "cpf", unique = true),
                @Index(name = "empl_idx_rg", columnList = "rg", unique = true),
                @Index(name = "empl_idx_workCard", columnList = "workCard", unique = true),
        }

)
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_empl")
    private Long id;

    @Embedded
    private PersonalData personalData;

    @Embedded
    private EmployeeData employeeData;

    @Embedded
    private Contact contact;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_sector")
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_jobfun")
    private JobFunction jobFunction;
}
