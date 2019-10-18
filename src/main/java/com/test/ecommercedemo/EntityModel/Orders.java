package com.test.ecommercedemo.EntityModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
//import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int id;

    @NotNull
    int user_id;

    @NotNull
    Date date;

    @NotNull
    Time time;

    @NotNull
    String delivery_address;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getUser_id() { return user_id; }

    public void setUser_id(int user_id) { this.user_id = user_id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Time getTime() { return time; }

    public void setTime(Time time) { this.time = time; }

    public String getDelivery_address() { return delivery_address; }

    public void setDelivery_address(String delivery_address) { this.delivery_address = delivery_address; }
}
