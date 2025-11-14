package com.nfsystems.rhsync_api.user.models;

import com.nfsystems.rhsync_api.company.models.Company;
import com.nfsystems.rhsync_api.employee.models.Employee;
import com.nfsystems.rhsync_api.group.models.Group;
import com.nfsystems.rhsync_api.role.models.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "rhs_user",
        indexes = {
                @Index(name = "usr_idx_em", columnList = "email", unique = true),
        }
)
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rhs_user_fname", length = 100, nullable = false)
    private String firstName;

    @Column(name = "rhs_user_lname", length = 80, nullable = false)
    private String lastName;

    @Column(name = "rhs_user_email", length = 80, nullable = false, unique = true)
    private String email;

    @Column(name = "rhs_user_pass",nullable = false)
    private String password;

    @Column(name = "rhs_user_aclocked")
    private boolean accountLocked;

    @Column(name = "rhs_user_acenable")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_group")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "rhs_seq_company")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rhs_seq_empl", referencedColumnName = "id")
    private Employee employee;

    @CreatedDate
    @Column(name = "rhs_user_created_at",nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "rhs_user_updated_at",insertable = false)
    private LocalDateTime lastModifiedDate;


    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
