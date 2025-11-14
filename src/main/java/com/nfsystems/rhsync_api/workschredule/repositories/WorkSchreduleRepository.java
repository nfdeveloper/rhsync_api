package com.nfsystems.rhsync_api.workschredule.repositories;

import com.nfsystems.rhsync_api.group.models.Group;
import com.nfsystems.rhsync_api.sector.models.Sector;
import com.nfsystems.rhsync_api.workschredule.models.WorkSchredule;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkSchreduleRepository extends JpaRepository<WorkSchredule, Long> {

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    @Query("SELECT w FROM WorkSchredule w where w.group = :group")
    Page<WorkSchredule> findByGroupPagination(@Param("group") Group group, Pageable pageable);

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    List<WorkSchredule> findByGroup(Group group);
}
