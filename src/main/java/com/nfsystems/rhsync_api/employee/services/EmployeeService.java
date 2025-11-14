package com.nfsystems.rhsync_api.employee.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.employee.dto.EmployeeRequest;
import com.nfsystems.rhsync_api.employee.dto.EmployeeResponse;
import com.nfsystems.rhsync_api.employee.mappers.EmployeeMapper;
import com.nfsystems.rhsync_api.employee.models.Employee;
import com.nfsystems.rhsync_api.employee.repositories.EmployeeRepository;
import com.nfsystems.rhsync_api.file.services.BucketMinioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeService extends BaseService<Employee, Long, EmployeeRepository> {

    private EmployeeMapper mapper;
    private BucketMinioService bucketMinioService;

    @Value("${minio.config.bucket-image-profile-name}")
    private String bucketImageProfileName;

    protected EmployeeService(EmployeeRepository repository,
                              EmployeeMapper mapper,
                              BucketMinioService bucketMinioService
                              ) {
        super(repository);
        this.mapper = mapper;
        this.bucketMinioService = bucketMinioService;
    }

    public EmployeeResponse findById(Long id){
        var employee = mapper.toDto(findByIdBase(id));
        employee.setPhotoProfile(bucketMinioService.getByteArray(bucketImageProfileName, employee.getPersonalData().getPhoto()));
        return employee;
    }

    @Transactional
    public Long create(EmployeeRequest request){
        Employee employee = mapper.toEmployee(request);
        repository.save(employee);
        // TODO - Create User and Send Validation Email.
        return employee.getId();
    }

    @Transactional
    public void uploadImageProfile(MultipartFile file, Long employeeId) {
        Employee employee = findByIdBase(employeeId);
        var photoUrl = bucketMinioService.uploadFile(bucketImageProfileName,file);
        employee.getPersonalData().setPhoto(photoUrl);
        repository.save(employee);
    }
}
