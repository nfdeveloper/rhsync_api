package com.nfsystems.rhsync_api.role.repositories;

import com.nfsystems.rhsync_api.role.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
