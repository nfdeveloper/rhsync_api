package com.nfsystems.rhsync_api.company.repositories;

import com.nfsystems.rhsync_api.common.dto.SelectItem;
import com.nfsystems.rhsync_api.company.models.Company;
import com.nfsystems.rhsync_api.group.models.Group;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    List<Company> findAllByGroup(Group group);

    @Query(value = "SELECT new com.nfsystems.rhsync_api.common.dto.SelectItem(c.id, c.companyData.fantasyName) FROM Company c WHERE c.group = :group")
    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    List<SelectItem<Long, String>> findSelectItemsByGroup(Group group);
}
