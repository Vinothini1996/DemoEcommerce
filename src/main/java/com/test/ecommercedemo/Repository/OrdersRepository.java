package com.test.ecommercedemo.Repository;

import com.test.ecommercedemo.Entity.Orders;
import com.test.ecommercedemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    List<Orders> findByUserId(Integer userId);

    @Query(value = "SELECT * FROM orders o INNER JOIN paymentdetails p ON o.id=p.order_id where o.user_id=?1 and p.payment_type=?2", nativeQuery = true)
    List<Orders> findByUserIdAndPaymentType(User user, String paymentType);

}
