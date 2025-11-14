package com.nfsystems.rhsync_api.employee.resources;

import com.nfsystems.rhsync_api.company.dto.CompanyResponse;
import com.nfsystems.rhsync_api.employee.dto.EmployeeRequest;
import com.nfsystems.rhsync_api.employee.dto.EmployeeResponse;
import com.nfsystems.rhsync_api.employee.services.EmployeeService;
import com.nfsystems.rhsync_api.file.services.BucketMinioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
public class EmployeeResource {

    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody EmployeeRequest request){
        return ResponseEntity.ok(service.create(request));
    }

    @PostMapping(value = "image-profile/{employeeId}", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadImageProfile(@RequestPart("file") MultipartFile file, @PathVariable Long employeeId){
        service.uploadImageProfile(file, employeeId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

}
