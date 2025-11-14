package com.nfsystems.rhsync_api.sector.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.group.services.GroupService;
import com.nfsystems.rhsync_api.sector.dto.SectorRequest;
import com.nfsystems.rhsync_api.sector.dto.SectorResponse;
import com.nfsystems.rhsync_api.sector.mappers.SectorMapper;
import com.nfsystems.rhsync_api.sector.models.Sector;
import com.nfsystems.rhsync_api.sector.repositories.SectorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SectorService extends BaseService<Sector, Long, SectorRepository> {

    private SectorMapper mapper;
    private GroupService groupService;

    protected SectorService(SectorRepository repository,
                            SectorMapper mapper,
                            GroupService groupService
                            ) {
        super(repository);
        this.mapper = mapper;
        this.groupService = groupService;
    }

    public Page<SectorResponse> list(Long groupId, Pageable pageable){
        // TODO - Get By Authenticate User
        var group = groupService.findByIdBase(groupId);
        return repository.findByGroupPagination(group, pageable).map(mapper::toResponse);
    }

    @Transactional
    public Long create(SectorRequest request){
        var sector = mapper.toSector(request);
        // TODO - Setar Group
        return save(sector).getId();
    }
}
