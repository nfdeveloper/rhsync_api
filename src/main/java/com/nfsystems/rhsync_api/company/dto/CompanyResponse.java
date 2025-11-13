package com.nfsystems.rhsync_api.company.dto;

import com.nfsystems.rhsync_api.common.models.Address;
import com.nfsystems.rhsync_api.common.models.Contact;
import com.nfsystems.rhsync_api.company.models.CompanyData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CompanyResponse {
    private Long id;
    private CompanyData companyData;
    private Boolean parentCompany;
    private Contact contact;
    private Address address;
}
