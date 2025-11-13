package com.nfsystems.rhsync_api.jobfunction.repositories;

import com.nfsystems.rhsync_api.group.models.Group;
import com.nfsystems.rhsync_api.jobfunction.models.JobFunction;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

public interface JobFunctionRepository extends JpaRepository<JobFunction, Long> {

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    @Query("SELECT j FROM JobFunction j where j.group = :group")
    Page<JobFunction> findByGroup(@Param("group") Group group, Pageable pageable);
}
