//package com.example.sizzlingbitesapp;
//
//import android.app.Application;
//import android.content.Context;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ApplicationMain extends Application implements UpdateSelectedItems {
//
//    private static Context context;
//    private ArrayList<OrderListModel> orderListModels;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        context = getApplicationContext();
//        orderListModels = new ArrayList<>();
//    }
//
//    public static Context getMyContext() {
//        return context;
//    }
//
//    @Override
//    public void addItems(String name, int price) {
//        // Default quantity set to 1
//        orderListModels.add(new OrderListModel(name, price, 1));
//    }
//
//    @Override
//    public ArrayList<OrderListModel> getItems() {
//        return orderListModels;
//    }
//}
