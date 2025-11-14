package com.nfsystems.rhsync_api.workschredule.mappers;

import com.nfsystems.rhsync_api.workschredule.dto.WorkSchreduleRequest;
import com.nfsystems.rhsync_api.workschredule.dto.WorkSchreduleResponse;
import com.nfsystems.rhsync_api.workschredule.models.WorkSchredule;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class WorkSchreduleMapper {

    public WorkSchredule toWorkSchredule(WorkSchreduleRequest request){
        return WorkSchredule.builder()
                .name(request.name())
                .entry(LocalTime.parse(request.entry()))
                .intervalOut(LocalTime.parse(request.intervalOut()))
                .intervalBack(LocalTime.parse(request.intervalBack()))
                .out(LocalTime.parse(request.out()))
                .build();
    }

    public WorkSchreduleResponse toDto(WorkSchredule obj){
        return new WorkSchreduleResponse(
                obj.getId(),
                obj.getName(),
                obj.getEntry().toString(),
                obj.getIntervalOut().toString(),
                obj.getIntervalBack().toString(),
                obj.getOut().toString()
        );
    }
}
