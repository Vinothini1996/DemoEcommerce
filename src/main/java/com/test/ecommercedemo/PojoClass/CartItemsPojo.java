package com.test.ecommercedemo.PojoClass;

import com.test.ecommercedemo.Entity.Product;
import com.test.ecommercedemo.Entity.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CartItemsPojo {
    private Integer id;
    private UserPojo user;
    private ProductPojo product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserPojo getUser() {
        return user;
    }

    public void setUser(UserPojo user) {
        this.user = user;
    }

    public ProductPojo getProduct() {
        return product;
    }

    public void setProduct(ProductPojo product) {
        this.product = product;
    }
}
