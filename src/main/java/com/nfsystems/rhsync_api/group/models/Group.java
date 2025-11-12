package com.nfsystems.rhsync_api.group.models;

import com.nfsystems.rhsync_api.common.models.Address;
import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.common.models.Contact;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "rhs_grp",
        indexes = {
                @Index(name = "grp_idx_nm", columnList = "name", unique = true),
                @Index(name = "grp_idx_slg", columnList = "slug", unique = true)
        }

)
public class Group extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rhs_seq_grp")
    private Long id;

    @Column(name = "rhs_nm_grp", length = 120, unique = true)
    private String name;

    @Column(name = "rhs_slg_grp", length = 80, unique = true)
    private String slug;

    @Column(name = "rhs_lg_grp", length = 120, unique = true)
    private String logoUrl;

    @Column(name = "rhs_prm_cl_grp", length = 20)
    private String primaryColor;

    @Column(name = "rhs_sec_cl_grp", length = 20)
    private String secondaryColor;

    @Embedded
    private Contact contact;

    @Embedded
    private Address address;

    public void makeSlugGroup(){
        var words = this.name.split(" ");
        if(words.length >= 2){
            this.slug = words[0].toLowerCase()+"-"+words[1].toLowerCase();
        }
        else {
            this.slug = words[0].toLowerCase();
        }
    }
}
