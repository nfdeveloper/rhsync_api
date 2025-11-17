package com.nfsystems.rhsync_api.inventory.repositories;

import com.nfsystems.rhsync_api.inventory.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
