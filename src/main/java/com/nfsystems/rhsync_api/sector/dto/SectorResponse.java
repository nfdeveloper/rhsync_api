package com.nfsystems.rhsync_api.sector.dto;

public record SectorResponse(
        Long id,
        String name,
        String description,
        Integer employeeQuantity,
        String status
) { }
