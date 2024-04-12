package com.example.sizzlingbitesapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class DashBoardFragment extends Fragment implements UpdateRecyclerView{

    private RecyclerView recyclerView, recyclerView2;
    private StaticRvAdapter staticRvAdapter;
    LottieAnimationView lottie;

    EditText search;

    ArrayList<DynamicRVModel> items = new ArrayList<>();
    DynamicRvAdapter dynamicRvAdapter;
    int pos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dashboard_fragment, container, false);
        Log.d("Fragment", "onCreateView called");
        // Inflate the layout for this fragment


        search = root.findViewById(R.id.search);
        search.setOnClickListener(v -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            SearchFragment searchFragment = new SearchFragment();
            fragmentTransaction.replace(R.id.container, searchFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        });

        final ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.burger_svgrepo_com, "Burger"));
        item.add(new StaticRvModel(R.drawable.pizza_svgrepo_com, "Pizza"));
        item.add(new StaticRvModel(R.drawable.coffee_cup_coffee_svgrepo_com, "Coffee"));
        item.add(new StaticRvModel(R.drawable.soft_drink_soda_svgrepo_com, "Mocktails"));
        item.add(new StaticRvModel(R.drawable.french_fries_svgrepo_com, " French Fries"));
        item.add(new StaticRvModel(R.drawable.burrito, "Sandwich"));

        recyclerView = root.findViewById(R.id.rv_1);
        lottie = root.findViewById(R.id.lottieanim);
        staticRvAdapter = new StaticRvAdapter(item, getActivity(), this);
        lottie.setMaxFrame(60);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);

        items = new ArrayList<>();

        recyclerView2 = root.findViewById(R.id.rv_2);
        dynamicRvAdapter = new DynamicRvAdapter(items);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView2.setAdapter(dynamicRvAdapter);


        return root;
    }

    @SuppressLint("ResourceType")
    @Override
    public void callback(int position, ArrayList<DynamicRVModel> items) {

        dynamicRvAdapter = new DynamicRvAdapter(items);
        dynamicRvAdapter.notifyDataSetChanged();
        recyclerView2.setAdapter(dynamicRvAdapter);

        dynamicRvAdapter.setOnItemClickListener(position1 -> {
            pos = items.get(position1).getPos();
            // Assuming you have a FragmentManager object, and you are currently in DashboardFragment
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


            NearbyResFragment nearbyResFragment = new NearbyResFragment();
            fragmentTransaction.replace(R.id.container, nearbyResFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

//            Intent intent = new Intent(getActivity(), ResDetailActivity.class);
//            intent.putExtra("pos", pos);
//            startActivity(intent);
            //i want toclick on an item in my dynamic adapter it should take me to a fragment created for the specific item of the adapter
        });


    }
}
