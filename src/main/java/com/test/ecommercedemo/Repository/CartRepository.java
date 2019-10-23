package com.test.ecommercedemo.Repository;

import com.test.ecommercedemo.Entity.CartItems;
import com.test.ecommercedemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItems, Integer> {

    List<CartItems> findByUser(User user);
}
