package com.nfsystems.rhsync_api.inventory.services;

import com.nfsystems.rhsync_api.common.services.BaseService;
import com.nfsystems.rhsync_api.inventory.models.CategoryProduct;
import com.nfsystems.rhsync_api.inventory.repositories.CategoryProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryProductService extends BaseService<CategoryProduct, Long, CategoryProductRepository> {

    protected CategoryProductService(CategoryProductRepository repository) {
        super(repository);
    }


}
