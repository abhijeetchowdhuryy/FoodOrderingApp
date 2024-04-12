package com.example.sizzlingbitesapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbitesapp.OrderListModel;
import com.example.sizzlingbitesapp.R;
import com.example.sizzlingbitesapp.totalAmountModel; // Import your totalAmountModel class here

import java.util.ArrayList;

public class TotalOrderFragmentAdapter extends RecyclerView.Adapter<TotalOrderFragmentAdapter.TotalOrderViewHolder> {

    private ArrayList<OrderListModel> orderListModels;
    private Activity activity;

    public TotalOrderFragmentAdapter(ArrayList<OrderListModel> orderListModels, Activity activity) {
        this.orderListModels = orderListModels;
        this.activity = activity;
    }

    public class TotalOrderViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;

        public TotalOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }

    @NonNull
    @Override
    public TotalOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.total_amount_item, parent, false);
        return new TotalOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TotalOrderViewHolder holder, int position) {
        OrderListModel currentItem = orderListModels.get(position);

        // Convert OrderListModel to totalAmountModel
        totalAmountModel totalModel = new totalAmountModel(currentItem.getName(), (int) currentItem.getPrice());

        // Bind data to views
        holder.name.setText(totalModel.getTotalname());
        holder.price.setText(String.valueOf(totalModel.getTotalprice()));
    }

    @Override
    public int getItemCount() {
        return orderListModels.size();
    }
}
