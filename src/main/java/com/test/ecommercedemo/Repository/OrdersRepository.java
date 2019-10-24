package com.test.ecommercedemo.Repository;

import com.test.ecommercedemo.Entity.Orders;
import com.test.ecommercedemo.Entity.PaymentType;
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
//SELECT o.id, o.date, o.delivery_address FROM orders o INNER JOIN payment_details p ON o.id=p.order_id WHERE o.user_id=?1 and p.payment_type=?2
    @Query("SELECT o FROM Orders o inner join PaymentDetails p on o.id=p.orders.id WHERE o.user=:user and p.paymentType=:paymentType")
    List<Orders> findByUserIdAndPaymentType(@Param("user") User user,@Param("paymentType") PaymentType paymentType);

}
