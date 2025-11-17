package com.nfsystems.rhsync_api.marking.mappers;

import com.nfsystems.rhsync_api.marking.dto.MarkingRequest;
import com.nfsystems.rhsync_api.marking.dto.MarkingResponse;
import com.nfsystems.rhsync_api.marking.models.Marking;
import org.springframework.stereotype.Service;

@Service
public class MarkingMapper {

    public Marking toMarking(MarkingRequest request){
        return Marking.builder()
                .id(request.id())
                .year(request.date().getYear())
                .month(request.date().getMonthValue())
                .day(request.date().getDayOfMonth())
                .hour(request.date().getHour())
                .minute(request.date().getMinute())
                .build();
    }

    public MarkingResponse toDto(Marking obj){
        return MarkingResponse.builder()
                .id(obj.getId())
                .year(obj.getYear())
                .month(obj.getMonth())
                .day(obj.getDay())
                .minute(obj.getMinute())
                .hour(obj.getHour())
                .build();
    }
}
