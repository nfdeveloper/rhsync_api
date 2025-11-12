package com.nfsystems.rhsync_api.group.mappers;

import com.nfsystems.rhsync_api.group.dto.GroupRequest;
import com.nfsystems.rhsync_api.group.dto.GroupResponse;
import com.nfsystems.rhsync_api.group.models.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupMapper {

    public Group toGroup(GroupRequest request){
        return Group.builder()
                .name(request.getName())
                .primaryColor(request.getPrimaryColor())
                .secondaryColor(request.getSecondaryColor())
                .contact(request.getContact())
                .address(request.getAddress())
                .build();
    }

    public GroupResponse toResponse(Group obj){
        return GroupResponse.builder()
                .name(obj.getName())
                .slug(obj.getSlug())
                .address(obj.getAddress())
                .contact(obj.getContact())
                .primaryColor(obj.getPrimaryColor())
                .secondaryColor(obj.getSecondaryColor())
                //.logoUrl()
                .build();
    }
}
