package com.test.ecommercedemo.Service;

import com.test.ecommercedemo.Entity.Orders;
import com.test.ecommercedemo.Entity.PaymentDetails;
import com.test.ecommercedemo.PojoClass.PaymentPojo;
import com.test.ecommercedemo.Repository.OrdersRepository;
import com.test.ecommercedemo.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    public List<PaymentPojo> getPaymentDetailByOrderId(Integer orderId) {
        Orders orders=ordersRepository.getOne(orderId);
        List<PaymentDetails> paymentDetailsList=paymentRepository.findByOrders(orders);
        List<PaymentPojo> paymentPojoList=new ArrayList<>();
        paymentDetailsList.forEach(paymentDetails -> {
            PaymentPojo paymentPojo=new PaymentPojo();
            paymentPojo.setId(paymentDetails.getId());
            //paymentPojo.setOrderId(paymentDetails.getOrderId());
            paymentPojo.setPaymentType(paymentDetails.getPaymentType());
            paymentPojo.setAmount(paymentDetails.getAmount());
            paymentPojoList.add(paymentPojo);
        });
        return paymentPojoList;
    }
}
