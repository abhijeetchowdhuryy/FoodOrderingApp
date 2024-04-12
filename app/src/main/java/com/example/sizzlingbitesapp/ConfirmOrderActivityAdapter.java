package com.example.sizzlingbitesapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConfirmOrderActivityAdapter extends RecyclerView.Adapter<ConfirmOrderActivityAdapter.ConfirmOrderViewHolder> {

    private ArrayList<OrderListModel> orderListModels;
    private Activity activity;
    private double totalAmount; // Variable to store the total amount

    public ConfirmOrderActivityAdapter(ArrayList<OrderListModel> orderListModels, Activity activity) {
        this.orderListModels = orderListModels;
        this.activity = activity;
    }


    public class ConfirmOrderViewHolder extends RecyclerView.ViewHolder {

        TextView name, price, quantityText;
        ImageView plus, minus;

        public ConfirmOrderViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quantityText = itemView.findViewById(R.id.quantity);
            plus = itemView.findViewById(R.id.plus);
            minus = itemView.findViewById(R.id.minus);

            plus.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    OrderListModel currentItem = orderListModels.get(position);
                    currentItem.incrementQuantity();
                    notifyItemChanged(position);
                    calculateTotalAmount(); // Recalculate total amount
                }
            });

            minus.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    OrderListModel currentItem = orderListModels.get(position);
                    currentItem.decrementQuantity();
                    notifyItemChanged(position);
                    calculateTotalAmount(); // Recalculate total amount
                }
            });
        }
    }

    @NonNull
    @Override
    public ConfirmOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.order_item, parent, false);
        ConfirmOrderViewHolder confirmOrderViewHolder = new ConfirmOrderViewHolder(view);
        return confirmOrderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmOrderViewHolder holder, int position) {
        OrderListModel currentItem = orderListModels.get(position);
        holder.name.setText(currentItem.getName());
        holder.price.setText(String.valueOf(currentItem.getPrice()));
        holder.quantityText.setText(String.valueOf(currentItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return orderListModels.size();
    }

    // Calculate total amount method
    private void calculateTotalAmount() {
        totalAmount = 0;
        for (OrderListModel item : orderListModels) {
            totalAmount += item.getQuantity() * item.getPrice();
        }
    }

    // Getter method for total amount
    public double getTotalAmount() {
        return totalAmount;
    }
}
