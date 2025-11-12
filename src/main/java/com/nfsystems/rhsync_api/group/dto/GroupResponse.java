package com.nfsystems.rhsync_api.group.dto;

import com.nfsystems.rhsync_api.common.models.Address;
import com.nfsystems.rhsync_api.common.models.Contact;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GroupResponse {
    private Long id;
    private String name;
    private String slug;
    private byte[] logoUrl;
    private String primaryColor;
    private String secondaryColor;
    private Contact contact;
    private Address address;
}
