package com.test.ecommercedemo.PojoClass;

import java.sql.Date;

public class OrderByCartPojo {
    private Integer id;
    private Date date;
    private String deliveryAddress;
    private CartItemsPojo cartItemsPojo;
    private PaymentPojo paymentPojo;
    private ProductPojo productPojo;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getDeliveryAddress() { return deliveryAddress; }

    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public CartItemsPojo getCartItemsPojo() { return cartItemsPojo; }

    public void setCartItemsPojo(CartItemsPojo cartItemsPojo) { this.cartItemsPojo = cartItemsPojo; }

    public PaymentPojo getPaymentPojo() { return paymentPojo; }

    public void setPaymentPojo(PaymentPojo paymentPojo) { this.paymentPojo = paymentPojo; }

    public ProductPojo getProductPojo() { return productPojo; }

    public void setProductPojo(ProductPojo productPojo) { this.productPojo = productPojo; }
}
