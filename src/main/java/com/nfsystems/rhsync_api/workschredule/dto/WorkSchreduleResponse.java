package com.nfsystems.rhsync_api.workschredule.dto;

public record WorkSchreduleResponse(
        Long id,
        String name,
        String entry,
        String intervalOut,
        String intervalBack,
        String out
) {
}
