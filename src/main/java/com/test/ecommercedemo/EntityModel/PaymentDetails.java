package com.test.ecommercedemo.EntityModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "paymentdetails")
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int id;

    @NotNull
    int order_id;

    @Enumerated
    @NotNull
    Payment_type payment_type;

    @NotNull
    int amount;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getOrder_id() { return order_id; }

    public void setOrder_id(int order_id) { this.order_id = order_id; }

    public Payment_type getPayment_type() { return payment_type; }

    public void setPayment_type(Payment_type payment_type) { this.payment_type = payment_type; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }
}
