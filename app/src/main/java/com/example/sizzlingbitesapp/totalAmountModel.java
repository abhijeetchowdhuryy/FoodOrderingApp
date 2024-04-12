package com.example.sizzlingbitesapp;

public class totalAmountModel {
    String Totalname;
    int Totalprice;

    public totalAmountModel(String Totalname, int Totalprice) {
        this.Totalname = Totalname;
        this.Totalprice = Totalprice;
    }

    public String getTotalname() {
        return Totalname;
    }

    public int getTotalprice() {
        return Totalprice;
    }
}
