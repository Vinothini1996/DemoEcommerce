package com.test.ecommercedemo.EntityModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int id;

    @NotNull
    String name;

    @NotNull
    String description;

    @NotNull
    int price;

    @NotNull
    int stock_available;

    @OneToMany(mappedBy = "product")
    private List<CartItems> cartItemsList;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public int getStock_available() { return stock_available; }

    public void setStock_available(int stock_available) { this.stock_available = stock_available; }

    public List<CartItems> getCartItemsList() {
        return cartItemsList;
    }

    public void setCartItemsList(List<CartItems> cartItemsList) {
        this.cartItemsList = cartItemsList;
    }
}
