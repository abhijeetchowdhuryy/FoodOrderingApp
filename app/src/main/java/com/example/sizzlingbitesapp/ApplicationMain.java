package com.example.sizzlingbitesapp;

import android.app.Application;
import android.content.Context;

import com.example.sizzlingbitesapp.OrderListModel;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMain extends Application implements UpdateSelectedItems {

    private static Context context;
    ArrayList<OrderListModel> orderListModels;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        orderListModels = new ArrayList<>();
    }

    public static Context getMyContext() {
        return context;
    }

    @Override
    public void addItems(String name, int price) {
        orderListModels.add(new OrderListModel(name, price, 1));
    }

    @Override
    public List<Item> getItems2() {
        return null;
    }
}