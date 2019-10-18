package com.test.ecommercedemo.EntityModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cartitems")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int id;

    @NotNull
    int user_id;

    @NotNull
    int product_id;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name ="product_id", referencedColumnName = "id")
//    private Product product;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getUser_id() { return user_id; }

    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getProduct_id() { return product_id; }

    public void setProduct_id(int product_id) { this.product_id = product_id; }
}
