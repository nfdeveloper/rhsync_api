package com.nfsystems.rhsync_api.company.dto;

import com.nfsystems.rhsync_api.common.models.Address;
import com.nfsystems.rhsync_api.common.models.Contact;
import com.nfsystems.rhsync_api.company.models.CompanyData;
import com.nfsystems.rhsync_api.group.models.Group;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CompanyRequest {

    private Long id;
    private CompanyData companyData;
    private Boolean parentCompany = Boolean.FALSE;
    private Contact contact;
    private Address address;
    private Long groupId;
}
