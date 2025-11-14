package com.nfsystems.rhsync_api.sector.models;

import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.company.models.Company;
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
@Table(
        name = "rhs_sect",
        indexes = {
                @Index(name = "sect_idx_nm", columnList = "rhs_nm_sect"),
        }

)
public class Sector extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_sect")
    private Long id;

    @Column(name = "rhs_nm_sect", length = 120)
    private String name;

    @Column(name = "rhs_desc_sect", length = 300)
    private String description;

    @Column(name = "rhs_empqtd_sect")
    private Integer employeeQuantity;

    // TODO - Responsável pelo setor

    @ManyToOne
    @JoinColumn(name = "rhs_seq_grp")
    private Group group;

}
