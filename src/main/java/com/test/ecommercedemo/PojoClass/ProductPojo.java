package com.test.ecommercedemo.PojoClass;

public class ProductPojo {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer stockAvailable;

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

    public Integer getStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(Integer stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    public ProductPojo() {
    }

    public ProductPojo(Integer id, String name, String description, Integer price, Integer stockAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAvailable = stockAvailable;
    }
}
