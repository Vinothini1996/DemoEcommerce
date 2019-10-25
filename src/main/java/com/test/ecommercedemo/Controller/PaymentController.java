package com.test.ecommercedemo.Controller;

import com.test.ecommercedemo.PojoClass.PaymentPojo;
import com.test.ecommercedemo.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/byorderid/{id}")
    List<PaymentPojo> findPaymentDetailsByOrderId(@PathVariable("id") Integer orderId){
        return paymentService.getPaymentDetailByOrderId(orderId);
    }

}
