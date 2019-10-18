package com.test.ecommercedemo.Repository;

import com.test.ecommercedemo.EntityModel.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
