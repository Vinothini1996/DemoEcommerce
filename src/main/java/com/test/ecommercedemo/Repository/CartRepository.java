package com.test.ecommercedemo.Repository;

import com.test.ecommercedemo.EntityModel.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItems,Integer> {
}
