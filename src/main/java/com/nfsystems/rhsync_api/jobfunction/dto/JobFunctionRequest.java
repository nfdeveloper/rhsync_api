package com.nfsystems.rhsync_api.jobfunction.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class JobFunctionRequest {
    private Long id;
    private String name;
    private String description;
    private Boolean insalubrity;
    private Boolean periculosity;
    private Boolean needEpi;
    private BigDecimal salaryBase;
    private Long groupId;
}
