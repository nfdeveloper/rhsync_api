package com.nfsystems.rhsync_api.employee.repositories;

import com.nfsystems.rhsync_api.company.models.Company;
import com.nfsystems.rhsync_api.employee.models.Employee;
import com.nfsystems.rhsync_api.group.models.Group;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    @Query("SELECT e FROM Employee e where e.company.group = :group")
    Page<Employee> findByGroupPagination(Group group, Pageable pageable);

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    @Query("SELECT e FROM Employee e where e.company = :company")
    Page<Employee> findByCompanyPagination(Company company, Pageable pageable);

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    Optional<Employee> findByCpf(String cpf);
}
