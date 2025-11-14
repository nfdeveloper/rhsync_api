package com.nfsystems.rhsync_api.group.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.exceptions.RHSEntityNotFoundException;
import com.nfsystems.rhsync_api.file.services.BucketMinioService;
import com.nfsystems.rhsync_api.group.dto.GroupRequest;
import com.nfsystems.rhsync_api.group.dto.GroupResponse;
import com.nfsystems.rhsync_api.group.mappers.GroupMapper;
import com.nfsystems.rhsync_api.group.models.Group;
import com.nfsystems.rhsync_api.group.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GroupService extends BaseService<Group, Long, GroupRepository> {

    private GroupMapper mapper;
    private BucketMinioService bucketMinioService;

    @Value("${minio.config.bucket-image-group-name}")
    private String bucketImageGroupName;

    protected GroupService(GroupRepository repository,
                           GroupMapper mapper,
                           BucketMinioService bucketMinioService
                           ) {
        super(repository);
        this.mapper = mapper;
        this.bucketMinioService = bucketMinioService;
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

    @Transactional
    public void uploadImageLogo(MultipartFile file, Long groupId) {
        Group group = findByIdBase(groupId);
        var logoUrl = bucketMinioService.uploadFile(bucketImageGroupName, file);
        group.setLogoUrl(logoUrl);
        repository.save(group);
    }
}
