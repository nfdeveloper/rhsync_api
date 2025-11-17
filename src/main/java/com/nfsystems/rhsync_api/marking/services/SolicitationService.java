package com.nfsystems.rhsync_api.marking.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.marking.dto.SolicitationRequest;
import com.nfsystems.rhsync_api.marking.mappers.SolicitationMapper;
import com.nfsystems.rhsync_api.marking.models.Solicitation;
import com.nfsystems.rhsync_api.marking.repositories.SolicitationRepository;
import com.nfsystems.rhsync_api.user.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitationService extends BaseService<Solicitation, Long, SolicitationRepository> {

    private SolicitationMapper mapper;

    protected SolicitationService(SolicitationRepository repository,
                                  SolicitationMapper mapper
                                  ) {
        super(repository);
        this.mapper = mapper;
    }

    private User getAuthenticationUser(Authentication connectedUser){
        return (User) connectedUser.getPrincipal();
    }

    @Transactional
    public Long create(Authentication connectUser, SolicitationRequest request){
        var solicitation = mapper.toSolicitation(request);
        solicitation.setEmployee(getAuthenticationUser(connectUser).getEmployee());
        return save(solicitation).getId();
    }


}
