//package com.example.sizzlingbitesapp;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//class DashboardActivity extends AppCompatActivity {
//    @SuppressLint("ResourceType")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dash_board);
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.layout.login_tab_fragment, new DashBoardFragment())
//                .commit();
//    }
//}


//package com.example.sizzlingbitesapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import com.airbnb.lottie.LottieAnimationView;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//public class DashBoardActivity extends AppCompatActivity {
//
//    private RecyclerView recyclerView;
//    private StaticRvAdapter staticRvAdapter;
//    LottieAnimationView lottie;
//
//    List<DynamicRVModel> items = new ArrayList<>();
//    DynamicRvAdapter dynamicRvAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dash_board);
//        lottie = findViewById(R.id.lottieanim);
//        lottie.setMaxFrame(60); // Assuming the animation runs at 60 frames per second, 4 seconds would be 60 frames * 4 seconds = 240 frames
//
//        final ArrayList<StaticRvModel> item = new ArrayList<>();
//        item.add(new StaticRvModel(R.drawable.pizza_svgrepo_com, "Pizza"));
//        item.add(new StaticRvModel(R.drawable.coffee_cup_coffee_svgrepo_com, "Coffee"));
//        item.add(new StaticRvModel(R.drawable.burger_svgrepo_com, "Burger"));
//        item.add(new StaticRvModel(R.drawable.soft_drink_soda_svgrepo_com, "Soda"));
//        item.add(new StaticRvModel(R.drawable.french_fries_svgrepo_com, "French Fries"));
//
//        recyclerView = findViewById(R.id.rv_1);
//        staticRvAdapter = new StaticRvAdapter(item);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.setAdapter(staticRvAdapter);
//
//        items.add(new DynamicRVModel("Pizza"));
//        items.add(new DynamicRVModel("Coffee"));
//        items.add(new DynamicRVModel("Burger"));
//        items.add(new DynamicRVModel("Soda"));
//        items.add(new DynamicRVModel("French Fries"));
//        items.add(new DynamicRVModel("Pizza"));
//        items.add(new DynamicRVModel("Coffee"));
//        items.add(new DynamicRVModel("Burger"));
//        items.add(new DynamicRVModel("Soda"));
//        items.add(new DynamicRVModel("French Fries"));
//
//        RecyclerView drv = findViewById(R.id.rv_2);
//        drv.setLayoutManager(new LinearLayoutManager(this));
//        dynamicRvAdapter = new DynamicRvAdapter(drv, this, items);
//        drv.setAdapter(dynamicRvAdapter);
//
//        dynamicRvAdapter.setLoadMore(() -> {
//            if (items.size() <= 20) {
//                items.add(null);
//                dynamicRvAdapter.notifyItemInserted(items.size() - 1);
//                drv.postDelayed(() -> {
//                    items.remove(items.size() - 1);
//                    dynamicRvAdapter.notifyItemRemoved(items.size());
//
//                    int index = items.size();
//                    int end = index + 10;
//                    for (int i = index; i < end; i++) {
//                        String name = UUID.randomUUID().toString();
//                        DynamicRVModel item1 = new DynamicRVModel(name);
//                        items.add(item1);
//                    }
//                    dynamicRvAdapter.notifyDataSetChanged();
//                    dynamicRvAdapter.setLoaded();
//                }, 4000);
//            }
//            else{
//                Toast.makeText(this, "Data Completed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}