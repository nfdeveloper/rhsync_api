package com.nfsystems.rhsync_api.employee.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.employee.dto.EmployeeRequest;
import com.nfsystems.rhsync_api.employee.mappers.EmployeeMapper;
import com.nfsystems.rhsync_api.employee.models.Employee;
import com.nfsystems.rhsync_api.employee.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService extends BaseService<Employee, Long, EmployeeRepository> {

    private EmployeeMapper mapper;

    protected EmployeeService(EmployeeRepository repository,
                              EmployeeMapper mapper
                              ) {
        super(repository);
        this.mapper = mapper;
    }

    @Transactional
    public Long create(EmployeeRequest request){
        Employee employee = mapper.toEmployee(request);
        repository.save(employee);
        // TODO - Create User and Send Validation Email.
        return employee.getId();
    }
}
