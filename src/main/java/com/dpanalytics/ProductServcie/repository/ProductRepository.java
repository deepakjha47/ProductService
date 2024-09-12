package com.dpanalytics.ProductServcie.repository;

import com.dpanalytics.ProductServcie.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
