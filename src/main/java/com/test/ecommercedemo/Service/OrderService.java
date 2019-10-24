package com.test.ecommercedemo.Service;

import com.test.ecommercedemo.Entity.Orders;
import com.test.ecommercedemo.Entity.PaymentType;
import com.test.ecommercedemo.Entity.User;
import com.test.ecommercedemo.PojoClass.OrdersPojo;
import com.test.ecommercedemo.Repository.OrdersRepository;
import com.test.ecommercedemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserRepository userRepository;

    public List<OrdersPojo> getOrderDetailByUserId(Integer userId, String paymentType) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            PaymentType paymentType1=PaymentType.valueOf(paymentType);
            List<Orders> ordersList = ordersRepository.findByUserIdAndPaymentType(optionalUser.get(),paymentType1);
            List<OrdersPojo> ordersPojoList = new ArrayList<>();
            ordersList.forEach(orders -> {
                OrdersPojo ordersPojo = new OrdersPojo();
                ordersPojo.setId(orders.getId());
                ordersPojo.setUserId(orders.getUser().getId());
                ordersPojo.setDate(orders.getDate());
                ordersPojo.setDeliveryAddress(orders.getDeliveryAddress());
                ordersPojoList.add(ordersPojo);
            });
            return ordersPojoList;
        }
        else{
            return null;
        }
    }

}
