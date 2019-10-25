package com.test.ecommercedemo.PojoClass;

import java.sql.Date;

public class OrderPostPojo {
    private Integer id;
    private Date date;
    private String deliveryAddress;
    private ProductPojo productPojo;
    private UserPojo userPojo;
    private PaymentPojo paymentPojo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public ProductPojo getProductPojo() {
        return productPojo;
    }

    public void setProductPojo(ProductPojo productPojo) {
        this.productPojo = productPojo;
    }

    public UserPojo getUserPojo() {
        return userPojo;
    }

    public void setUserPojo(UserPojo userPojo) {
        this.userPojo = userPojo;
    }

    public PaymentPojo getPaymentPojo() { return paymentPojo; }

    public void setPaymentPojo(PaymentPojo paymentPojo) { this.paymentPojo = paymentPojo; }
}
