package com.nfsystems.rhsync_api.common.models;

import com.nfsystems.rhsync_api.common.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rhs_st")
    private Status status = Status.ACTIVE;

    @CreatedDate
    @Column(name = "rhs_cre_at",nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "rhs_up_at",insertable = false)
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(name = "rhs_cre_by", updatable = false)
    private Long createdBy;

    @LastModifiedBy
    @Column(name = "rhs_last_mod_by",insertable = false)
    private Long lastModifiedBy;

    public void alterarStatus(){
        if(this.status == Status.ACTIVE){
            this.status = Status.INACTIVE;
        } else {
            this.status = Status.ACTIVE;
        }
    }
}
