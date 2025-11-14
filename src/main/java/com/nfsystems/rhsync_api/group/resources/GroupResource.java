package com.nfsystems.rhsync_api.group.resources;

import com.nfsystems.rhsync_api.group.dto.GroupRequest;
import com.nfsystems.rhsync_api.group.dto.GroupResponse;
import com.nfsystems.rhsync_api.group.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/groups")
@AllArgsConstructor
public class GroupResource {

    private final GroupService service;

    @GetMapping
    public ResponseEntity<Page<GroupResponse>> listPagination(Pageable pageable){
        return ResponseEntity.ok(service.listPaginationResponse(pageable));
    }

    @GetMapping("{slug}")
    public ResponseEntity<GroupResponse> findBySlug(@PathVariable String slug){
        return ResponseEntity.ok(service.findBySlug(slug));
    }

    @PostMapping(value ="group-image/{groupId}", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadImageProfile(@RequestPart("file") MultipartFile file, @PathVariable Long groupId){
        service.uploadImageLogo(file, groupId);
        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody GroupRequest request){
        Long id = service.create(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
