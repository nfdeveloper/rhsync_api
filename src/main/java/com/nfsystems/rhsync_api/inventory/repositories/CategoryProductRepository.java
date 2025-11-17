package com.nfsystems.rhsync_api.inventory.repositories;

import com.nfsystems.rhsync_api.inventory.models.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {
}
