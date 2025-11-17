package com.nfsystems.rhsync_api.marking.repositories;

import com.nfsystems.rhsync_api.marking.models.Solicitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitationRepository extends JpaRepository<Solicitation, Long> {
}
