package com.nfsystems.rhsync_api.marking.dto;

import java.time.LocalDateTime;

public record MarkingPublisherRequest(
        LocalDateTime date,
        Long employeeId
) {
}
