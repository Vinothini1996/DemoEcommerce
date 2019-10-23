package com.test.ecommercedemo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="user",uniqueConstraints = {@UniqueConstraint(columnNames = {"username","mobileNo","emailId"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String mobileNo;

    @NotNull
    private String emailId;

    @NotNull
    private String address;

    @NotNull
    private String zipCode;

    @OneToMany()
    @JoinColumn(name = "user_id")
    private List<CartItems> cartItems;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getMobileNo() { return mobileNo; }

    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public List<CartItems> getCartItems() { return cartItems; }

    public void setCartItems(List<CartItems> cartItems) { this.cartItems = cartItems; }
}
