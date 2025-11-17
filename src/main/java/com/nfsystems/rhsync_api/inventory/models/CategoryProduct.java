package com.nfsystems.rhsync_api.inventory.models;

import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.company.models.Company;
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
        name = "rhs_catprd",
        indexes = {
                @Index(name = "catprd_idx_nm", columnList = "rhs_nm_catprd")
        }

)
public class CategoryProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_catprd")
    private Long id;

    @Column(name = "rhs_nm_catprd",length = 80)
    private String name;

    @Column(name = "rhs_desc_catprd",length = 300)
    private String description;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_company")
    private Company company;
}
