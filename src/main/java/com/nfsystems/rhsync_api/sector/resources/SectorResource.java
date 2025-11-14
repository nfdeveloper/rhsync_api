package com.nfsystems.rhsync_api.sector.resources;

import com.nfsystems.rhsync_api.sector.dto.SectorRequest;
import com.nfsystems.rhsync_api.sector.dto.SectorResponse;
import com.nfsystems.rhsync_api.sector.services.SectorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/sectors")
@AllArgsConstructor
public class SectorResource {

    private final SectorService service;

    @GetMapping
    public ResponseEntity<Page<SectorResponse>> listPagination(Pageable pageable){
        return ResponseEntity.ok(service.list(1L,pageable));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SectorRequest request){
        Long id = service.create(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
