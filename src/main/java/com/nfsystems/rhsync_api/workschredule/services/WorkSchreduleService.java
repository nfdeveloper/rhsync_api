package com.nfsystems.rhsync_api.workschredule.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.group.models.Group;
import com.nfsystems.rhsync_api.workschredule.dto.WorkSchreduleRequest;
import com.nfsystems.rhsync_api.workschredule.dto.WorkSchreduleResponse;
import com.nfsystems.rhsync_api.workschredule.mappers.WorkSchreduleMapper;
import com.nfsystems.rhsync_api.workschredule.models.WorkSchredule;
import com.nfsystems.rhsync_api.workschredule.repositories.WorkSchreduleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkSchreduleService extends BaseService<WorkSchredule, Long, WorkSchreduleRepository> {

    private WorkSchreduleMapper mapper;

    protected WorkSchreduleService(WorkSchreduleRepository repository,
                                   WorkSchreduleMapper mapper
                                   ) {
        super(repository);
        this.mapper = mapper;
    }

    public Page<WorkSchreduleResponse> listWithPagination(Pageable pageable){
        return repository.findByGroupPagination(new Group(), pageable)
                .map(mapper::toDto);
    }

    @Transactional
    public Long create(WorkSchreduleRequest request){
        var obj = mapper.toWorkSchredule(request);
        // TODO - Group
        return save(obj).getId();
    }
}
