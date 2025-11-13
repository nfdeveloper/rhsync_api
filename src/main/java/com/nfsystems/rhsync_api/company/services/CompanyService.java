package com.nfsystems.rhsync_api.company.services;

import com.nfsystems.rhsync_api.common.dto.SelectItem;
import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.company.dto.CompanyRequest;
import com.nfsystems.rhsync_api.company.dto.CompanyResponse;
import com.nfsystems.rhsync_api.company.mapper.CompanyMapper;
import com.nfsystems.rhsync_api.company.models.Company;
import com.nfsystems.rhsync_api.company.repositories.CompanyRepository;
import com.nfsystems.rhsync_api.group.models.Group;
import com.nfsystems.rhsync_api.group.services.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService extends BaseService<Company, Long, CompanyRepository> {

    private CompanyMapper mapper;
    private GroupService groupService;

    protected CompanyService(CompanyRepository repository,
                             CompanyMapper mapper,
                             GroupService groupService
                             ) {
        super(repository);
        this.mapper = mapper;
        this.groupService = groupService;
    }

    public List<SelectItem<Long, String>> listSelectItensByGroup(Long groupId){
        Group group = groupService.findByIdBase(groupId);
        return repository.findSelectItemsByGroup(group);
    }

    public Page<CompanyResponse> list(Pageable pageable){
        return listPagination(pageable)
                .map(mapper::toDto);
    }

    public List<CompanyResponse> listByGroup(Long groupId){
        Group group = groupService.findByIdBase(groupId);
        return repository.findAllByGroup(group).stream().map(mapper::toDto).toList();
    }

    @Transactional
    public Long create(CompanyRequest request){
        var company = mapper.toCompany(request);
        company.setGroup(groupService.findByIdBase(request.getGroupId()));
        return save(company).getId();
    }
}
