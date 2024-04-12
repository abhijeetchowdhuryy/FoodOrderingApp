package com.example.sizzlingbitesapp;

import java.util.ArrayList;

public interface UpdateRecyclerView2 {
    public void callback(int position, ArrayList<DynamicRV2Model> items);

    void onItemClick(int position);
}
