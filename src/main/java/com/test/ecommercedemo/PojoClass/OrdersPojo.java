package com.test.ecommercedemo.PojoClass;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

public class OrdersPojo {
    private Integer id;
    private Integer userId;
    private Date date;
    private Time time;
    private String deliveryAddress;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
