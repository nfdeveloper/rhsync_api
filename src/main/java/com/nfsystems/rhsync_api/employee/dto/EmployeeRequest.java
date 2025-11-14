package com.nfsystems.rhsync_api.employee.dto;

import com.nfsystems.rhsync_api.common.models.Address;
import com.nfsystems.rhsync_api.common.models.Contact;
import com.nfsystems.rhsync_api.employee.models.EmployeeData;
import com.nfsystems.rhsync_api.employee.models.PersonalData;

public record EmployeeRequest(
        Long id,
        PersonalData personalData,
        EmployeeData employeeData,
        Contact contact,
        Address address,
        Long companyId,
        Long sectorId,
        Long jobFunctionId
) { }
