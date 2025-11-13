package com.nfsystems.rhsync_api.jobfunction.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.group.services.GroupService;
import com.nfsystems.rhsync_api.jobfunction.dto.JobFunctionRequest;
import com.nfsystems.rhsync_api.jobfunction.dto.JobFunctionResponse;
import com.nfsystems.rhsync_api.jobfunction.mappers.JobFunctionMapper;
import com.nfsystems.rhsync_api.jobfunction.models.JobFunction;
import com.nfsystems.rhsync_api.jobfunction.repositories.JobFunctionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobFunctionService extends BaseService<JobFunction, Long, JobFunctionRepository> {

    private JobFunctionMapper mapper;
    private GroupService groupService;

    protected JobFunctionService(JobFunctionRepository repository,
                                 JobFunctionMapper mapper,
                                 GroupService groupService
                                 ) {
        super(repository);
        this.mapper = mapper;
        this.groupService = groupService;
    }

    public Page<JobFunctionResponse> list(Pageable pageable){
        return listPagination(pageable).map(mapper::toResponse);
    }

    @Transactional
    public Long create(JobFunctionRequest request){
        var jobFunction = mapper.toJobFunction(request);
        jobFunction.setGroup(groupService.findByIdBase(request.getGroupId()));
        return save(jobFunction).getId();
    }
}
