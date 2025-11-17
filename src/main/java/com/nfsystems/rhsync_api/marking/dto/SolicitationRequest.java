package com.nfsystems.rhsync_api.marking.dto;

import com.nfsystems.rhsync_api.marking.models.enums.SolicitationStatus;
import com.nfsystems.rhsync_api.marking.models.enums.SolicitationType;

import java.time.LocalDateTime;

public record SolicitationRequest(
        LocalDateTime date,
        SolicitationType type,
        Long markingId
) {
}
