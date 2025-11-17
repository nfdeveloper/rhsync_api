package com.nfsystems.rhsync_api.marking.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.marking.dto.MarkingPublisherRequest;
import com.nfsystems.rhsync_api.marking.dto.MarkingRequest;
import com.nfsystems.rhsync_api.marking.dto.MarkingResponse;
import com.nfsystems.rhsync_api.marking.mappers.MarkingMapper;
import com.nfsystems.rhsync_api.marking.models.Marking;
import com.nfsystems.rhsync_api.marking.repositories.MarkingRepository;
import com.nfsystems.rhsync_api.publisher.MarkingPublisher;
import com.nfsystems.rhsync_api.user.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarkingService extends BaseService<Marking, Long, MarkingRepository> {

    private MarkingMapper mapper;
    private MarkingPublisher markingPublisher;

    protected MarkingService(MarkingRepository repository,
                             MarkingMapper mapper,
                             MarkingPublisher markingPublisher
                             ) {
        super(repository);
        this.mapper = mapper;
        this.markingPublisher = markingPublisher;
    }

    private User getAuthenticationUser(Authentication connectedUser){
        return (User) connectedUser.getPrincipal();
    }

    public List<MarkingResponse> listAllDayEmployee(Authentication connectedUser, Integer year, Integer month, Integer day){
        return repository.findByEmployeeAndDayAndMonthAndYear(
                getAuthenticationUser(connectedUser).getEmployee(),
                day,
                month,
                year
        ).stream()
                .map(mapper::toDto)
                .toList();
    }

    // TODO - Fila Kafka
    @Transactional
    public void create(MarkingRequest request, Authentication connectedUser){
        var marking = mapper.toMarking(request);
        MarkingPublisherRequest reqKafka = new MarkingPublisherRequest(
                request.date(),
                getAuthenticationUser(connectedUser).getEmployee().getId()
        );

        markingPublisher.publish(reqKafka);
    }


}
