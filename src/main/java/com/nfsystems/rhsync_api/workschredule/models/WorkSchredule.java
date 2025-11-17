package com.nfsystems.rhsync_api.workschredule.models;

import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.group.models.Group;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "rhs_wrksc",
        indexes = {
                @Index(name = "wrksc_idx_nm", columnList = "rhs_nm_wrksc"),
                @Index(name = "wrksc_idx_entry", columnList = "rhs_ent_wrksc")
        }

)
public class WorkSchredule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_wrksc")
    private Long id;

    @Column(name = "rhs_nm_wrksc", length = 120)
    private String name;

    @Column(name = "rhs_ent_wrksc")
    private LocalTime entry;

    @Column(name = "rhs_intOut_wrksc")
    private LocalTime intervalOut;

    @Column(name = "rhs_intBac_wrksc")
    private LocalTime intervalBack;

    @Column(name = "rhs_out_wrksc")
    private LocalTime out;

    @Column(name = "rhs_hr_wrk_day_wrksc")
    private Integer hoursWorkDay;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_grp")
    private Group group;
}
