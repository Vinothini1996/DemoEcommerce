package com.test.ecommercedemo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
//import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date")
    private Date date;

    @NotNull
    @Column(name = "delivery_address")
    private String deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "orders")
    private PaymentDetails paymentDetails;

    @OneToMany(mappedBy = "orders")
    private List<OrderItems> orderItemsList;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public PaymentDetails getPaymentDetails() { return paymentDetails; }

    public void setPaymentDetails(PaymentDetails paymentDetails) { this.paymentDetails = paymentDetails; }

    public List<OrderItems> getOrderItemsList() { return orderItemsList; }

    public void setOrderItemsList(List<OrderItems> orderItemsList) { this.orderItemsList = orderItemsList; }
}
