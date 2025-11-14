package com.nfsystems.rhsync_api.sector.mappers;

import com.nfsystems.rhsync_api.sector.dto.SectorRequest;
import com.nfsystems.rhsync_api.sector.dto.SectorResponse;
import com.nfsystems.rhsync_api.sector.models.Sector;
import org.springframework.stereotype.Service;

@Service
public class SectorMapper {

    public Sector toSector(SectorRequest request){
        return Sector.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .employeeQuantity(request.employeeQuantity())
                .build();
    }

    public SectorResponse toResponse(Sector obj){
        return new SectorResponse(
                obj.getId(),
                obj.getName(),
                obj.getDescription(),
                obj.getEmployeeQuantity(),
                obj.getStatus().getValue()
        );
    }
}
