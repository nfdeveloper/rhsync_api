package com.nfsystems.rhsync_api.marking.models;

import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.employee.models.Employee;
import com.nfsystems.rhsync_api.marking.models.enums.SolicitationStatus;
import com.nfsystems.rhsync_api.marking.models.enums.SolicitationType;
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
        name = "rhs_solmrk",
        indexes = {
                @Index(name = "solmrk_idx_hour", columnList = "rhs_hour_solmrk"),
                @Index(name = "solmrk_idx_min", columnList = "rhs_min_solmrk")
        }

)
public class Solicitation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_solmrk")
    private Long id;

    @Column(name = "rhs_year_solmrk")
    private Integer year;

    @Column(name = "rhs_month_solmrk")
    private Integer month;

    @Column(name = "rhs_day_solmrk")
    private Integer day;

    @Column(name = "rhs_hour_solmrk")
    private Integer hour;

    @Column(name = "rhs_min_solmrk")
    private Integer minute;

    @Column(name = "rhs_resrejec_solmrk")
    private String reasonRejected;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rhs_tp_solmrk")
    private SolicitationType type;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rhs_st_solmrk")
    private SolicitationStatus statusSolicitation;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_mrk")
    private Marking marking;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_empl")
    private Employee employee;
}
