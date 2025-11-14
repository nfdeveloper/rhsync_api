package com.nfsystems.rhsync_api.workschredule.dto;

public record WorkSchreduleRequest(
        Long id,
        String name,
        String entry,
        String intervalOut,
        String intervalBack,
        String out
) { }
