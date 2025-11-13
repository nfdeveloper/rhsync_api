package com.nfsystems.rhsync_api.company.resources;

import com.nfsystems.rhsync_api.common.dto.SelectItem;
import com.nfsystems.rhsync_api.company.dto.CompanyRequest;
import com.nfsystems.rhsync_api.company.dto.CompanyResponse;
import com.nfsystems.rhsync_api.company.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
@AllArgsConstructor
public class CompanyResource {

    private final CompanyService service;

    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> listPagination(Pageable pageable){
        return ResponseEntity.ok(service.list(pageable));
    }

    @GetMapping("group/{groupId}")
    public ResponseEntity<List<CompanyResponse>> listByGroup(@PathVariable Long groupId){
        return ResponseEntity.ok(service.listByGroup(groupId));
    }

    @GetMapping("group/select-items/{groupId}")
    public ResponseEntity<List<SelectItem<Long, String>>> listSelectItems(@PathVariable Long groupId){
        return ResponseEntity.ok(service.listSelectItensByGroup(groupId));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CompanyRequest request){
        Long id = service.create(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
