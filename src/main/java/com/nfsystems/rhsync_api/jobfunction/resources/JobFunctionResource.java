package com.nfsystems.rhsync_api.jobfunction.resources;

import com.nfsystems.rhsync_api.jobfunction.dto.JobFunctionRequest;
import com.nfsystems.rhsync_api.jobfunction.dto.JobFunctionResponse;
import com.nfsystems.rhsync_api.jobfunction.services.JobFunctionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/jobfunctions")
@AllArgsConstructor
public class JobFunctionResource {

    private final JobFunctionService service;

    @GetMapping
    public ResponseEntity<Page<JobFunctionResponse>> list(Pageable pageable){
        return ResponseEntity.ok(service.list(pageable));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody JobFunctionRequest request){
        Long id = service.create(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
