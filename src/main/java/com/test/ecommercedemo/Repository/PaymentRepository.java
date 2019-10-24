package com.test.ecommercedemo.Repository;

import com.test.ecommercedemo.Entity.Orders;
import com.test.ecommercedemo.Entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetails, Integer> {

    public List<PaymentDetails> findByOrders(Orders orderId);
}
