package com.nfsystems.rhsync_api.jobfunction.models;

import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.group.models.Group;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rhs_jobfunc")
public class JobFunction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_jobfun")
    private Long id;

    @Column(name = "rhs_nm_jobfun", length = 80)
    private String name;

    @Column(name = "rhs_dec_jobfun", length = 500)
    private String description;

    @Column(name = "rhs_ins_jobfun")
    private Boolean insalubrity;

    @Column(name = "rhs_degrins_jobfun")
    private Integer degreeInsalubrity;

    @Column(name = "rhs_per_jobfun", length = 80)
    private Boolean periculosity;

    @Column(name = "rhs_need_epi_jobfun", length = 80)
    private Boolean needEpi;

    @Column(name = "rhs_sal_jobfun", precision = 16, scale = 2)
    private BigDecimal salaryBase;

    @ManyToOne
    @JoinColumn(name = "cvs_seq_group")
    private Group group;
}
