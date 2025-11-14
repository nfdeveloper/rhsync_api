package com.nfsystems.rhsync_api.employee.dto;

import com.nfsystems.rhsync_api.common.models.Address;
import com.nfsystems.rhsync_api.common.models.Contact;
import com.nfsystems.rhsync_api.employee.models.EmployeeData;
import com.nfsystems.rhsync_api.employee.models.PersonalData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeResponse{
    private Long id;
    private PersonalData personalData;
    private EmployeeData employeeData;
    private Contact contact;
    private Address address;
    private byte[] photoProfile;
}
