package com.example.sizzlingbitesapp;

public class DynamicRV2Model {

    String name;
    String price;
    String rating;

    public DynamicRV2Model(String name, String price, String rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;


    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }
}
