package com.nfsystems.rhsync_api.employee.mappers;

import com.nfsystems.rhsync_api.employee.dto.EmployeeRequest;
import com.nfsystems.rhsync_api.employee.dto.EmployeeResponse;
import com.nfsystems.rhsync_api.employee.models.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public Employee toEmployee(EmployeeRequest request){
        return Employee.builder()
                .id(request.id())
                .employeeData(request.employeeData())
                .personalData(request.personalData())
                .address(request.address())
                .contact(request.contact())
                .build();
    }

    public EmployeeResponse toDto(Employee obj){
        return new EmployeeResponse(
                obj.getId(),
                obj.getPersonalData(),
                obj.getEmployeeData(),
                obj.getContact(),
                obj.getAddress()
        );
    }
}
