//package com.example.sizzlingbitesapp;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.WindowManager;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.airbnb.lottie.LottieAnimationView;
//
//import java.util.ArrayList;
//
//public class ResDetailActivity extends AppCompatActivity implements UpdateRecyclerView2, StaticRvAdapter2.OnItemClickListener {
//
//    private RecyclerView rv_1, rv_2;
//    private StaticRvAdapter2 staticRvAdapter2;
//    private DynamicRV2Adapter dynamicRV2Adapter;
//    private ArrayList<DynamicRV2Model> items;
//    Activity context;
//    LottieAnimationView cart;
//
//    UpdateSelectedItems updateSelectedItems;
//    int pos;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_res_detail);
//
//        Intent intent = getIntent();
//        pos = intent.getIntExtra("pos", 0);
//
//        // Initialize the items list
//        items = new ArrayList<>();
//
//        // Create an ArrayList to hold your static data
//        ArrayList<StaticRVModel2> staticItems = new ArrayList<>();
//        staticItems.add(new StaticRVModel2(R.drawable.burger, pos));
//        staticItems.add(new StaticRVModel2(R.drawable.pizza, pos));
//        staticItems.add(new StaticRVModel2(R.drawable.coffee, pos));
//        staticItems.add(new StaticRVModel2(R.drawable.soft_drink, pos));
//        staticItems.add(new StaticRVModel2(R.drawable.french_fries, pos));
//        staticItems.add(new StaticRVModel2(R.drawable.burrito, pos));
//
//        // Create the static adapter with the static data
//        staticRvAdapter2 = new StaticRvAdapter2(staticItems, this, this);
//
//        // Find and set up the static RecyclerView
//        rv_1 = findViewById(R.id.rv_1);
//        rv_1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        rv_1.setAdapter(staticRvAdapter2);
//
//        items = new ArrayList<>();
//        dynamicRV2Adapter = new DynamicRV2Adapter(items, context, updateSelectedItems);
//        rv_2 = findViewById(R.id.rv_2);
//        rv_2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        rv_2.setAdapter(dynamicRV2Adapter);
//
//        cart = findViewById(R.id.cart);
//        cart.setOnClickListener(view -> {
//            Intent intent1 = new Intent(ResDetailActivity.this, ConfirmOrderActivity.class);
//            startActivity(intent1);
//        });
//    }
//
//    @Override
//    public void callback(int position, ArrayList<DynamicRV2Model> items) {
//        dynamicRV2Adapter.setItems(items);
//        dynamicRV2Adapter.notifyDataSetChanged();
//    }
//
//    @Override
//    public void onItemClick(int position) {
//        // Handle item click event from StaticRvAdapter2
//        // You can implement navigation logic here to open another activity or perform any action
//        Toast.makeText(this, "Clicked on item at position: " + position, Toast.LENGTH_SHORT).show();
//    }
//}
