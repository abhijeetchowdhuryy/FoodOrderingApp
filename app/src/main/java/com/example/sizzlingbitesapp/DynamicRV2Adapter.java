package com.example.sizzlingbitesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DynamicRV2Adapter extends RecyclerView.Adapter<DynamicRV2Adapter.DynamicRv2Holder> {

    private ArrayList<DynamicRV2Model> dynamicRV2Models;
    private Context context;
    private UpdateSelectedItems updateSelectedItems;

    public DynamicRV2Adapter(ArrayList<DynamicRV2Model> dynamicRV2Models, Context context, UpdateSelectedItems updateSelectedItems) {
        this.dynamicRV2Models = dynamicRV2Models;
        this.context = context;
        this.updateSelectedItems = updateSelectedItems;
    }

    public void setItems(ArrayList<DynamicRV2Model> items) {
        this.dynamicRV2Models.clear();
        this.dynamicRV2Models.addAll(items);
        notifyDataSetChanged();
    }

    public interface UpdateSelectedItems {
        void addItems(String name, int price);
    }


    public class DynamicRv2Holder extends RecyclerView.ViewHolder {
        public TextView name, price, rating;
        public ImageView add_item, done;

        public DynamicRv2Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            add_item = itemView.findViewById(R.id.add_item);
            done = itemView.findViewById(R.id.done);
        }
    }

    @NonNull
    @Override
    public DynamicRv2Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv2_item_layout, parent, false);
        return new DynamicRv2Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRv2Holder holder, int position) {
        DynamicRV2Model currentItem = dynamicRV2Models.get(position);
        holder.name.setText(currentItem.getName());
        holder.price.setText(currentItem.getPrice());

        holder.add_item.setOnClickListener(v -> {
            String name = currentItem.getName();
            // Remove non-numeric characters from the price string before parsing
            String priceString = currentItem.getPrice().replaceAll("[^\\d]", "");
            int price = Integer.parseInt(priceString);

            // Notify the listener
            if (updateSelectedItems != null) {
                updateSelectedItems.addItems(name, price);
            }

            holder.add_item.setVisibility(View.GONE);
            holder.done.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public int getItemCount() {
        return dynamicRV2Models.size();
    }
}
