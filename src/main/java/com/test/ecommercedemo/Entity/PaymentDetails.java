package com.test.ecommercedemo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "payment_details")
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @NotNull
    @Column(name = "amount")
    private Integer amount;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders orders;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Orders getOrders() { return orders; }

    public void setOrders(Orders orders) { this.orders = orders; }
}
