package com.nfsystems.rhsync_api.marking.resources;

import com.nfsystems.rhsync_api.marking.dto.MarkingRequest;
import com.nfsystems.rhsync_api.marking.dto.MarkingResponse;
import com.nfsystems.rhsync_api.marking.services.MarkingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/markings")
@AllArgsConstructor
public class MarkingResource {

    private final MarkingService service;

    @GetMapping
    public ResponseEntity<List<MarkingResponse>> getListDay(
            @RequestParam(name = "year", required = true) Integer year,
            @RequestParam(name = "month", required = true) Integer month,
            @RequestParam(name = "day", required = true) Integer day,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.listAllDayEmployee(connectedUser, year, month, day));
    }

    @PostMapping
    public ResponseEntity<Void> create(Authentication connectedUser, @RequestBody MarkingRequest request){
        var id = service.create(request, connectedUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
