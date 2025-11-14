package com.nfsystems.rhsync_api.auth.dto;

public record RegistrationRequest(
        String firstname,
        String lastname,
        String email,
        String password,
        Long roleId,
        Long groupId
) {
}
