package com.nfsystems.rhsync_api.group.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.exceptions.RHSEntityNotFoundException;
import com.nfsystems.rhsync_api.group.dto.GroupRequest;
import com.nfsystems.rhsync_api.group.dto.GroupResponse;
import com.nfsystems.rhsync_api.group.mappers.GroupMapper;
import com.nfsystems.rhsync_api.group.models.Group;
import com.nfsystems.rhsync_api.group.repositories.GroupRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupService extends BaseService<Group, Long, GroupRepository> {

    private GroupMapper mapper;

    protected GroupService(GroupRepository repository,
                           GroupMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    public GroupResponse findById(Long id){
        return mapper.toResponse(findByIdBase(id));
    }

    public Page<GroupResponse> listPaginationResponse(Pageable pageable){
        return listPagination(pageable).map(mapper::toResponse);
    }

    public GroupResponse findBySlug(String slug){
        return mapper.toResponse(repository.findBySlug(slug)
                .orElseThrow(() -> new RHSEntityNotFoundException("Grupo não encontrado.")));
    }

    @Transactional
    public Long create(GroupRequest request){
        var group = mapper.toGroup(request);
        group.makeSlugGroup();
        return save(group).getId();
    }

}
