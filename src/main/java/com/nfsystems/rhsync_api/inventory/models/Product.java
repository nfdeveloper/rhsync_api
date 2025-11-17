package com.nfsystems.rhsync_api.inventory.models;

import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.company.models.Company;
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
@Table(
        name = "rhs_prd",
        indexes = {
                @Index(name = "prd_idx_code", columnList = "rhs_cod_prd", unique = true),
                @Index(name = "prd_idx_nm", columnList = "rhs_nm_prd")
        }

)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_prd")
    private Long id;

    @Column(name = "rhs_cod_prd", unique = true)
    private String code;

    @Column(name = "rhs_nm_prd")
    private String name;

    @Column(name = "rhs_pric_prd", precision = 16, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_catprd")
    private CategoryProduct categoryProduct;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_company")
    private Company company;
}
