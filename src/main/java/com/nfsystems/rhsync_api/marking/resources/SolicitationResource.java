package com.nfsystems.rhsync_api.marking.resources;

import com.nfsystems.rhsync_api.marking.dto.SolicitationRequest;
import com.nfsystems.rhsync_api.marking.services.SolicitationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/markings")
@AllArgsConstructor
public class SolicitationResource {

    private final SolicitationService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SolicitationRequest request, Authentication connectedUser){
        var id = service.create(connectedUser, request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
