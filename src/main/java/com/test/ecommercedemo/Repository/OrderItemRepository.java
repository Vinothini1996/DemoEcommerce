package com.test.ecommercedemo.Repository;

import com.test.ecommercedemo.Entity.OrderItems;
import com.test.ecommercedemo.Entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems,Integer> {
}
