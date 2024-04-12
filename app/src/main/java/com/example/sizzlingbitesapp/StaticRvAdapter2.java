package com.example.sizzlingbitesapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbitesapp.DynamicRV2Model;
import com.example.sizzlingbitesapp.StaticRVModel2;
import com.example.sizzlingbitesapp.UpdateRecyclerView2;

import java.util.ArrayList;

public class StaticRvAdapter2 extends RecyclerView.Adapter<StaticRvAdapter2.StaticRV2ViewHolder> {

    private ArrayList<StaticRVModel2> items;
    private UpdateRecyclerView2 updateRecyclerView2;
    private Context context; // Change from Activity to Context
    private int row_index = -1;
    private boolean check = true;
    private boolean check2 = true;
    private boolean select = true;
    private int p;

    public StaticRvAdapter2(ArrayList<StaticRVModel2> items, UpdateRecyclerView2 updateRecyclerView2, Context context) { // Change parameter from Activity to Context
        this.items = items;
        this.updateRecyclerView2 = updateRecyclerView2;
        this.context = context; // Assign context
    }

    @NonNull
    @Override
    public StaticRV2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv2_item, parent, false);
        return new StaticRV2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRV2ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        StaticRVModel2 staticRVModel2 = items.get(position);
        holder.imageView.setImageResource(staticRVModel2.getImage());
        p = staticRVModel2.getPos();

        if (check2) {
            if(p == 0) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Mexican Burger", "$50", "4.5"));
                items.add(new DynamicRV2Model("Cheese Burger", "$100", "4.5"));
                items.add(new DynamicRV2Model("Turkey Burger", "$300", "4.5"));
                items.add(new DynamicRV2Model("Veggie Burger", "$200", "4.5"));
                items.add(new DynamicRV2Model("Bean Burger", "$400", "4.5"));
                items.add(new DynamicRV2Model("Wild Salmon Burger", "$500", "4.5"));
                items.add(new DynamicRV2Model("Hamburger", "$50", "4.5"));
                items.add(new DynamicRV2Model("Portobello mushroom Burger", "$100", "4.5"));
                items.add(new DynamicRV2Model("Elk Burger", "$300", "4.5"));
                items.add(new DynamicRV2Model("Beyond meat Burger", "$200", "4.5"));
                items.add(new DynamicRV2Model("Buffalo Burger", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            } else if (p == 1) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Margherita Pizza", "$50", "4.5"));
                items.add(new DynamicRV2Model("BBQ Chicken Pizza", "$100", "4.5"));
                items.add(new DynamicRV2Model("Pepperoni Pizza", "$300", "4.5"));
                items.add(new DynamicRV2Model("Hawaiian Pizza", "$200", "4.5"));
                items.add(new DynamicRV2Model("Meat Lover's Pizza", "$400", "4.5"));
                items.add(new DynamicRV2Model("Veggie Pizza", "$500", "4.5"));
                items.add(new DynamicRV2Model("Cheese Pizza", "$50", "4.5"));
                items.add(new DynamicRV2Model("Mushroom Pizza", "$100", "4.5"));
                items.add(new DynamicRV2Model("Sausage Pizza", "$300", "4.5"));
                items.add(new DynamicRV2Model("Buffalo Pizza", "$200", "4.5"));
                items.add(new DynamicRV2Model("Neapolitan Pizza", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            } else if (p == 2) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Espresso", "$50", "4.5"));
                items.add(new DynamicRV2Model("Cappuccino", "$100", "4.5"));
                items.add(new DynamicRV2Model("Cafe Latte", "$300", "4.5"));
                items.add(new DynamicRV2Model("Cafe Mocha", "$200", "4.5"));
                items.add(new DynamicRV2Model("Macchiato", "$400", "4.5"));
                items.add(new DynamicRV2Model("Americano", "$500", "4.5"));
                items.add(new DynamicRV2Model("Cortado", "$50", "4.5"));
                items.add(new DynamicRV2Model("Flat White", "$100", "4.5"));
                items.add(new DynamicRV2Model("Affogato", "$300", "4.5"));
                items.add(new DynamicRV2Model("Irish Coffee", "$200", "4.5"));
                items.add(new DynamicRV2Model("Turkish Coffee", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            } else if (p == 3) {

                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Coca-Cola", "$50", "4.5"));
                items.add(new DynamicRV2Model("Pepsi", "$100", "4.5"));
                items.add(new DynamicRV2Model("Sprite", "$300", "4.5"));
                items.add(new DynamicRV2Model("Fanta", "$200", "4.5"));
                items.add(new DynamicRV2Model("Mountain Dew", "$400", "4.5"));
                items.add(new DynamicRV2Model("Dr. Pepper", "$500", "4.5"));
                items.add(new DynamicRV2Model("7 Up", "$50", "4.5"));
                items.add(new DynamicRV2Model("Mirinda", "$100", "4.5"));
                items.add(new DynamicRV2Model("Diet Coke", "$300", "4.5"));
                items.add(new DynamicRV2Model("Diet Pepsi", "$200", "4.5"));
                items.add(new DynamicRV2Model("Diet Sprite", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            } else if (p == 4) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("French Fries", "$50", "4.5"));
                items.add(new DynamicRV2Model("Curly Fries", "$100", "4.5"));
                items.add(new DynamicRV2Model("Waffle Fries", "$300", "4.5"));
                items.add(new DynamicRV2Model("Sweet Potato Fries", "$200", "4.5"));
                items.add(new DynamicRV2Model("Chili Cheese Fries", "$400", "4.5"));
                items.add(new DynamicRV2Model("Poutine", "$500", "4.5"));
                items.add(new DynamicRV2Model("Disco Fries", "$50", "4.5"));
                items.add(new DynamicRV2Model("Garlic Fries", "$100", "4.5"));
                items.add(new DynamicRV2Model("Steak Fries", "$300", "4.5"));
                items.add(new DynamicRV2Model("Crinkle Cut Fries", "$200", "4.5"));
                items.add(new DynamicRV2Model("Shoestring Fries", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            }

            else if (p == 5) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Burrito", "$50", "4.5"));
                items.add(new DynamicRV2Model("Bean Burrito", "$100", "4.5"));
                items.add(new DynamicRV2Model("Chicken Burrito", "$300", "4.5"));
                items.add(new DynamicRV2Model("Veggie Burrito", "$200", "4.5"));
                items.add(new DynamicRV2Model("Beef Burrito", "$400", "4.5"));
                items.add(new DynamicRV2Model("Cheese Burrito", "$500", "4.5"));
                items.add(new DynamicRV2Model("California Burrito", "$50", "4.5"));
                items.add(new DynamicRV2Model("Breakfast Burrito", "$100", "4.5"));
                items.add(new DynamicRV2Model("Wet Burrito", "$300", "4.5"));
                items.add(new DynamicRV2Model("Chimichanga", "$200", "4.5"));
                items.add(new DynamicRV2Model("Smothered Burrito", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            }
            check2 = false;
        }


        if (check) {
            ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
            items.add(new DynamicRV2Model("Mexican Burger", "$50", "4.5"));
            items.add(new DynamicRV2Model("Cheese Burger", "$100", "4.5"));
            items.add(new DynamicRV2Model("Turkey Burger", "$300", "4.5"));
            items.add(new DynamicRV2Model("Veggie Burger", "$200", "4.5"));
            items.add(new DynamicRV2Model("Bean Burger", "$400", "4.5"));
            items.add(new DynamicRV2Model("Wild Salmon Burger", "$500", "4.5"));
            items.add(new DynamicRV2Model("Hamburger", "$50", "4.5"));
            items.add(new DynamicRV2Model("Portobello mushroom Burger", "$100", "4.5"));
            items.add(new DynamicRV2Model("Elk Burger", "$300", "4.5"));
            items.add(new DynamicRV2Model("Beyond meat Burger", "$200", "4.5"));
            items.add(new DynamicRV2Model("Buffalo Burger", "$400", "4.5"));

            updateRecyclerView2.callback(position, items);

            check = false;

        }
        holder.linearLayout.setOnClickListener(v -> {
            row_index = position;
            notifyDataSetChanged();

            if (position == 0) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Mexican Burger", "$50", "4.5"));
                items.add(new DynamicRV2Model("Cheese Burger", "$100", "4.5"));
                items.add(new DynamicRV2Model("Turkey Burger", "$300", "4.5"));
                items.add(new DynamicRV2Model("Veggie Burger", "$200", "4.5"));
                items.add(new DynamicRV2Model("Bean Burger", "$400", "4.5"));
                items.add(new DynamicRV2Model("Wild Salmon Burger", "$500", "4.5"));
                items.add(new DynamicRV2Model("Hamburger", "$50", "4.5"));
                items.add(new DynamicRV2Model("Portobello mushroom Burger", "$100", "4.5"));
                items.add(new DynamicRV2Model("Elk Burger", "$300", "4.5"));
                items.add(new DynamicRV2Model("Beyond meat Burger", "$200", "4.5"));
                items.add(new DynamicRV2Model("Buffalo Burger", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            }

            if (position == 1) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Margherita Pizza", "$50", "4.5"));
                items.add(new DynamicRV2Model("BBQ Chicken Pizza", "$100", "4.5"));
                items.add(new DynamicRV2Model("Pepperoni Pizza", "$300", "4.5"));
                items.add(new DynamicRV2Model("Hawaiian Pizza", "$200", "4.5"));
                items.add(new DynamicRV2Model("Meat Lover's Pizza", "$400", "4.5"));
                items.add(new DynamicRV2Model("Veggie Pizza", "$500", "4.5"));
                items.add(new DynamicRV2Model("Cheese Pizza", "$50", "4.5"));
                items.add(new DynamicRV2Model("Mushroom Pizza", "$100", "4.5"));
                items.add(new DynamicRV2Model("Sausage Pizza", "$300", "4.5"));
                items.add(new DynamicRV2Model("Buffalo Pizza", "$200", "4.5"));
                items.add(new DynamicRV2Model("Neapolitan Pizza", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            }

            if (position == 2) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Espresso", "$50", "4.5"));
                items.add(new DynamicRV2Model("Cappuccino", "$100", "4.5"));
                items.add(new DynamicRV2Model("Cafe Latte", "$300", "4.5"));
                items.add(new DynamicRV2Model("Cafe Mocha", "$200", "4.5"));
                items.add(new DynamicRV2Model("Macchiato", "$400", "4.5"));
                items.add(new DynamicRV2Model("Americano", "$500", "4.5"));
                items.add(new DynamicRV2Model("Cortado", "$50", "4.5"));
                items.add(new DynamicRV2Model("Flat White", "$100", "4.5"));
                items.add(new DynamicRV2Model("Affogato", "$300", "4.5"));
                items.add(new DynamicRV2Model("Irish Coffee", "$200", "4.5"));
                items.add(new DynamicRV2Model("Turkish Coffee", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            }

            if (position == 3) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Coca-Cola", "$50", "4.5"));
                items.add(new DynamicRV2Model("Pepsi", "$100", "4.5"));
                items.add(new DynamicRV2Model("Sprite", "$300", "4.5"));
                items.add(new DynamicRV2Model("Fanta", "$200", "4.5"));
                items.add(new DynamicRV2Model("Mountain Dew", "$400", "4.5"));
                items.add(new DynamicRV2Model("Dr. Pepper", "$500", "4.5"));
                items.add(new DynamicRV2Model("7 Up", "$50", "4.5"));
                items.add(new DynamicRV2Model("Mirinda", "$100", "4.5"));
                items.add(new DynamicRV2Model("Diet Coke", "$300", "4.5"));
                items.add(new DynamicRV2Model("Diet Pepsi", "$200", "4.5"));
                items.add(new DynamicRV2Model("Diet Sprite", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            }

            if (position == 4) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("French Fries", "$50", "4.5"));
                items.add(new DynamicRV2Model("Curly Fries", "$100", "4.5"));
                items.add(new DynamicRV2Model("Waffle Fries", "$300", "4.5"));
                items.add(new DynamicRV2Model("Sweet Potato Fries", "$200", "4.5"));
                items.add(new DynamicRV2Model("Chili Cheese Fries", "$400", "4.5"));
                items.add(new DynamicRV2Model("Poutine", "$500", "4.5"));
                items.add(new DynamicRV2Model("Disco Fries", "$50", "4.5"));
                items.add(new DynamicRV2Model("Garlic Fries", "$100", "4.5"));
                items.add(new DynamicRV2Model("Steak Fries", "$300", "4.5"));
                items.add(new DynamicRV2Model("Crinkle Cut Fries", "$200", "4.5"));
                items.add(new DynamicRV2Model("Shoestring Fries", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            }

            if (position == 5) {
                ArrayList<DynamicRV2Model> items = new ArrayList<DynamicRV2Model>();
                items.add(new DynamicRV2Model("Burrito", "$50", "4.5"));
                items.add(new DynamicRV2Model("Bean Burrito", "$100", "4.5"));
                items.add(new DynamicRV2Model("Chicken Burrito", "$300", "4.5"));
                items.add(new DynamicRV2Model("Veggie Burrito", "$200", "4.5"));
                items.add(new DynamicRV2Model("Beef Burrito", "$400", "4.5"));
                items.add(new DynamicRV2Model("Cheese Burrito", "$500", "4.5"));
                items.add(new DynamicRV2Model("California Burrito", "$50", "4.5"));
                items.add(new DynamicRV2Model("Breakfast Burrito", "$100", "4.5"));
                items.add(new DynamicRV2Model("Wet Burrito", "$300", "4.5"));
                items.add(new DynamicRV2Model("Chimichanga", "$200", "4.5"));
                items.add(new DynamicRV2Model("Smothered Burrito", "$400", "4.5"));

                updateRecyclerView2.callback(position, items);
            }

        });

        if (select) {
            if (position == 0) {
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv2_selected_bg);
                select = false;
            }
        }

        else {
            if(row_index == position){
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv2_selected_bg);
            } else {
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv2_bg);
            }
        }
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class StaticRV2ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        LinearLayout linearLayout;

        public StaticRV2ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.res_detail_item);
            linearLayout = itemView.findViewById(R.id.linearLayout2);
        }
    }
}
