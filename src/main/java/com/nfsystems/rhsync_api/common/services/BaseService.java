package com.nfsystems.rhsync_api.common.services;

import com.nfsystems.rhsync_api.common.models.BaseEntity;
import com.nfsystems.rhsync_api.exceptions.RHSEntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseService<T extends BaseEntity, ID, R extends JpaRepository<T, ID>> {

    protected final R repository;

    protected BaseService(R repository) {
        this.repository = repository;
    }

    public Page<T> listPagination(Pageable pageable){
        return repository.findAll(pageable);
    }

    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }

    public T findByIdBase(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RHSEntityNotFoundException("Entidade não encontrada."));
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Transactional
    public void updateStatus(T entity) {
        entity.alterarStatus();
        repository.save(entity);
    }
}
