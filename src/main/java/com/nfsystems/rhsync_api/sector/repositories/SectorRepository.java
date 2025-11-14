package com.nfsystems.rhsync_api.sector.repositories;

import com.nfsystems.rhsync_api.group.models.Group;
import com.nfsystems.rhsync_api.sector.models.Sector;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectorRepository extends JpaRepository<Sector, Long> {

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    @Query("SELECT s FROM Sector s where s.group = :group")
    Page<Sector> findByGroupPagination(@Param("group") Group group, Pageable pageable);

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    List<Sector> findByGroup(Group group);
}
