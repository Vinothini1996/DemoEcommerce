package com.test.ecommercedemo.EntityModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carddetails")
public class CardDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int id;

    @NotNull
    int user_id;

    @NotNull
    String card_type;

    @NotNull
    String card_no;

    @NotNull
    String bank_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
}
