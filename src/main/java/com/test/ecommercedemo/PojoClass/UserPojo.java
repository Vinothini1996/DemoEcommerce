package com.test.ecommercedemo.PojoClass;

import com.test.ecommercedemo.Entity.User;

public class UserPojo {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String mobileNo;
    private String emailId;
    private String address;
    private String zipCode;

    //private List<CartItemsPojo> cartItemsPojo;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() { return mobileNo; }

    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

//    public List<CartItemsPojo> getCartItemsPojo() { return cartItemsPojo; }
//
//    public void setCartItemsPojo(List<CartItemsPojo> cartItemsPojo) {
//        this.cartItemsPojo = cartItemsPojo;
//    }


    public UserPojo() {
    }

    public UserPojo(Integer id, String name, String username, String password, String mobileNo, String emailId, String address, String zipCode) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.address = address;
        this.zipCode = zipCode;
    }
}
