package com.test.ecommercedemo.EntityModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orderitems")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int id;

    @NotNull
    int order_id;

    @NotNull
    int product_id;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getOrder_id() { return order_id; }

    public void setOrder_id(int order_id) { this.order_id = order_id; }

    public int getProduct_id() { return product_id; }

    public void setProduct_id(int product_id) { this.product_id = product_id; }
}
