package com.nfsystems.rhsync_api.marking.repositories;

import com.nfsystems.rhsync_api.employee.models.Employee;
import com.nfsystems.rhsync_api.marking.models.Marking;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface MarkingRepository extends JpaRepository<Marking, Long> {

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    List<Marking> findByEmployee(Employee employee);

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    List<Marking> findByEmployeeAndDayAndMonthAndYear(
            Employee employee,
            Integer day,
            Integer month,
            Integer year
    );

    @QueryHints(value = {
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    List<Marking> findByEmployeeAndMonthAndYear(Employee employee, Integer month, Integer year);
}
