package com.nfsystems.rhsync_api.marking.models;

import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.employee.models.Employee;
import com.nfsystems.rhsync_api.marking.models.enums.StatusMarking;
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
        name = "rhs_mrk",
        indexes = {
                @Index(name = "mrk_idx_hour", columnList = "rhs_hour_mrk"),
                @Index(name = "mrk_idx_min", columnList = "rhs_min_mrk")
        }

)
public class Marking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_mrk")
    private Long id;

    @Column(name = "rhs_year_mrk")
    private Integer year;

    @Column(name = "rhs_month_mrk")
    private Integer month;

    @Column(name = "rhs_day_mrk")
    private Integer day;

    @Column(name = "rhs_hour_mrk")
    private Integer hour;

    @Column(name = "rhs_min_mrk")
    private Integer minute;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rhs_st_mrk")
    private StatusMarking status;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_empl")
    private Employee employee;
}
