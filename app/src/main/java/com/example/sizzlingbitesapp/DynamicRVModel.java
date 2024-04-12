package com.example.sizzlingbitesapp;

public class DynamicRVModel {
    String name;
    String details;

    private int image;
    int pos;

    public DynamicRVModel(String name, String details,  int image, int pos) {
        this.name = name;
        this.image = image;
        this.pos = pos;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public int getImage(){
        return image;
    }

    public int getPos(){
        return pos;
    }

    public String getDetails(){
        return details;
    }

}
