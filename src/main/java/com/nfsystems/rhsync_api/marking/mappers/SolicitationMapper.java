package com.nfsystems.rhsync_api.marking.mappers;

import com.nfsystems.rhsync_api.marking.dto.SolicitationRequest;
import com.nfsystems.rhsync_api.marking.dto.SolicitationResponse;
import com.nfsystems.rhsync_api.marking.models.Solicitation;
import org.springframework.stereotype.Service;

@Service
public class SolicitationMapper {

    public Solicitation toSolicitation(SolicitationRequest request){
        return Solicitation.builder()
                .year(request.date().getYear())
                .month(request.date().getMonthValue())
                .day(request.date().getDayOfMonth())
                .hour(request.date().getHour())
                .minute(request.date().getMinute())
                .type(request.type())
                .build();
    }

    public SolicitationResponse toDto(Solicitation obj){
        return SolicitationResponse.builder()
                .id(obj.getId())
                .year(obj.getYear())
                .month(obj.getMonth())
                .day(obj.getDay())
                .hour(obj.getHour())
                .minute(obj.getMinute())
                .statusSolicitation(obj.getStatusSolicitation().getValue())
                .type(obj.getType().getValue())
                .build();
    }
}
