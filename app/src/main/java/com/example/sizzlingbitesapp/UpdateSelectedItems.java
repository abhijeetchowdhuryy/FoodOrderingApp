package com.example.sizzlingbitesapp;

import java.util.List;

public interface UpdateSelectedItems {
    void addItems(String name, int price);
    List<Item> getItems(); // Change the return type
}
