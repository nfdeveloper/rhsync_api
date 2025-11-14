package com.nfsystems.rhsync_api.sector.dto;

public record SectorRequest(
        Long id,
        String name,
        String description,
        Integer employeeQuantity
) { }
