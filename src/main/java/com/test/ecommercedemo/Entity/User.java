package com.test.ecommercedemo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "username",unique = true)
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "mobile_no",unique = true)
    private String mobileNo;

    @NotNull
    @Column(name = "email_id",unique = true)
    private String emailId;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(mappedBy = "user")
    private List<CartItems> cartItems;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    @OneToMany(mappedBy = "user")
    private List<CardDetails> cardDetails;


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

    public List<Orders> getOrders() { return orders; }

    public void setOrders(List<Orders> orders) { this.orders = orders; }

    public List<CardDetails> getCardDetails() { return cardDetails; }

    public void setCardDetails(List<CardDetails> cardDetails) { this.cardDetails = cardDetails; }
}
