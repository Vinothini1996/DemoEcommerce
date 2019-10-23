package com.test.ecommercedemo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Integer price;

    @NotNull
    private Integer stockAvailable;

    @OneToMany()
    @JoinColumn(name = "product_id")
    private List<CartItems> cartItemsList;

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
}
