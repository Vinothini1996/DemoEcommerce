package com.test.ecommercedemo.EntityModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="user",uniqueConstraints = {@UniqueConstraint(columnNames = {"username","mobile_no","email_id"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int id;

    @NotNull
    String name;

    @NotNull
    private String username;

    @NotNull
    String password;

    @NotNull
    String mobileNo;

    @NotNull
    String email_id;

    @NotNull
    String address;

    @NotNull
    String zipcode;

//    @OneToMany(mappedBy = "user")
//    private List<CartItems> cartItemsList;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail_id() { return email_id; }

    public void setEmail_id(String email_id) { this.email_id = email_id; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

}
