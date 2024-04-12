package com.example.sizzlingbitesapp;

public class OrderListModel implements Item {
    private String name;
    private int price;
    private int quantity;

    public OrderListModel(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    // Method to increment quantity
    public void incrementQuantity() {
        quantity++;
    }

    // Method to decrement quantity
    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
}
