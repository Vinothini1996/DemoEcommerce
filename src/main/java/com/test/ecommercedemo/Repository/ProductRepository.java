package com.test.ecommercedemo.Repository;

import com.test.ecommercedemo.EntityModel.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
