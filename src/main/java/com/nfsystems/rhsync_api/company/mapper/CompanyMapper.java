package com.nfsystems.rhsync_api.company.mapper;

import com.nfsystems.rhsync_api.company.dto.CompanyRequest;
import com.nfsystems.rhsync_api.company.dto.CompanyResponse;
import com.nfsystems.rhsync_api.company.models.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper {

    public Company toCompany(CompanyRequest request){
        return Company.builder()
                .companyData(request.getCompanyData())
                .address(request.getAddress())
                .contact(request.getContact())
                .parentCompany(request.getParentCompany())
                .build();
    }

    public CompanyResponse toDto(Company obj){
        return CompanyResponse.builder()
                .id(obj.getId())
                .contact(obj.getContact())
                .address(obj.getAddress())
                .companyData(obj.getCompanyData())
                .parentCompany(obj.getParentCompany())
                .build();
    }
}
