package com.test.ecommercedemo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private Integer price;

    @NotNull
    @Column(name = "stock_available")
    private Integer stockAvailable;

    @OneToMany(mappedBy = "product")
    private List<CartItems> cartItemsList;

    @OneToMany(mappedBy = "product")
    private List<OrderItems> orderItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockAvailable() { return stockAvailable; }

    public void setStockAvailable(Integer stockAvailable) { this.stockAvailable = stockAvailable; }

    public List<CartItems> getCartItemsList() { return cartItemsList; }

    public void setCartItemsList(List<CartItems> cartItemsList) { this.cartItemsList = cartItemsList; }

    public List<OrderItems> getOrderItems() { return orderItems; }

    public void setOrderItems(List<OrderItems> orderItems) { this.orderItems = orderItems; }
}
