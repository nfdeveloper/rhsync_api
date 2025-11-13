package com.nfsystems.rhsync_api.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class SelectItem<L,V> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private L label;
    private V value;

    public SelectItem(){ super(); }

    public SelectItem(L label, V value){
        super();
        this.label = label;
        this.value = value;
    }
}
