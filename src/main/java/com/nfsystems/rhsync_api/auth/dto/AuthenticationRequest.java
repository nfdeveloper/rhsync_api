package com.nfsystems.rhsync_api.auth.dto;

public record AuthenticationRequest(
        String email,
        String password
) {
}

