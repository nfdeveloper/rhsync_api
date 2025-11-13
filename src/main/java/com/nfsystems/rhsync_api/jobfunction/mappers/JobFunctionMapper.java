package com.nfsystems.rhsync_api.jobfunction.mappers;

import com.nfsystems.rhsync_api.jobfunction.dto.JobFunctionRequest;
import com.nfsystems.rhsync_api.jobfunction.dto.JobFunctionResponse;
import com.nfsystems.rhsync_api.jobfunction.models.JobFunction;
import org.springframework.stereotype.Service;

@Service
public class JobFunctionMapper {

    public JobFunction toJobFunction(JobFunctionRequest request){
        return JobFunction.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .insalubrity(request.getInsalubrity())
                .periculosity(request.getPericulosity())
                .needEpi(request.getNeedEpi())
                .salaryBase(request.getSalaryBase())
                .build();
    }

    public JobFunctionResponse toResponse(JobFunction obj){
        return JobFunctionResponse.builder()
                .id(obj.getId())
                .name(obj.getName())
                .description(obj.getDescription())
                .insalubrity(obj.getInsalubrity())
                .periculosity(obj.getPericulosity())
                .needEpi(obj.getNeedEpi())
                .salaryBase(obj.getSalaryBase())
                .status(obj.getStatus().getValue())
                .build();
    }
}
