package com.nfsystems.rhsync_api.marking.dto;

import java.time.LocalDateTime;

public record MarkingRequest(
        Long id,
        LocalDateTime date
) {
}
