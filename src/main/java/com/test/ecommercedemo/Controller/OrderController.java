package com.test.ecommercedemo.Controller;

import com.test.ecommercedemo.PojoClass.OrdersPojo;
import com.test.ecommercedemo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/byUser/{id}/{paymentType}")
    List<OrdersPojo> getOrderDetailByUserId(@PathVariable("id") Integer userId,@PathVariable("paymentType") String paymentType){
        return orderService.getOrderDetailByUserId(userId,paymentType);
    }

}
