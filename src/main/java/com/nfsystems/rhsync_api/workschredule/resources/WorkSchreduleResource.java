package com.nfsystems.rhsync_api.workschredule.resources;

import com.nfsystems.rhsync_api.workschredule.dto.WorkSchreduleRequest;
import com.nfsystems.rhsync_api.workschredule.dto.WorkSchreduleResponse;
import com.nfsystems.rhsync_api.workschredule.services.WorkSchreduleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/work-schredule")
@AllArgsConstructor
public class WorkSchreduleResource {

    private final WorkSchreduleService service;

    @GetMapping
    public ResponseEntity<Page<WorkSchreduleResponse>> listPagination(Pageable pageable){
        return ResponseEntity.ok(service.listWithPagination(pageable));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody WorkSchreduleRequest request){
        var id = service.create(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
