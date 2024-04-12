package com.example.sizzlingbitesapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;

public class NearbyResFragment extends Fragment implements UpdateRecyclerView2, StaticRvAdapter2.OnItemClickListener {

    private RecyclerView rv_1, rv_2;
    private StaticRvAdapter2 staticRvAdapter2;
    private DynamicRV2Adapter dynamicRV2Adapter;
    private ArrayList<DynamicRV2Model> items;
    private LottieAnimationView cart;
    private TextView location;
    private Activity context;
    private int pos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.nearby_res_fragment, container, false);
        location = rootView.findViewById(R.id.location);
        location.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), MapsActivity.class);
            startActivity(intent);
        });

        // Remove the window's background to display fragment content correctly
        getActivity().getWindow().setBackgroundDrawable(null);

        // Get the position from arguments
        if (getArguments() != null) {
            pos = getArguments().getInt("pos", 0);
        }

        // Initialize the items list
        items = new ArrayList<>();

        // Create an ArrayList to hold your static data
        ArrayList<StaticRVModel2> staticItems = new ArrayList<>();
        staticItems.add(new StaticRVModel2(R.drawable.burger, pos));
        staticItems.add(new StaticRVModel2(R.drawable.pizza, pos));
        staticItems.add(new StaticRVModel2(R.drawable.coffee, pos));
        staticItems.add(new StaticRVModel2(R.drawable.soft_drink, pos));
        staticItems.add(new StaticRVModel2(R.drawable.french_fries, pos));
        staticItems.add(new StaticRVModel2(R.drawable.burrito, pos));

        // Create the static adapter with the static data
        staticRvAdapter2 = new StaticRvAdapter2(staticItems, this, getContext());

        // Find and set up the static RecyclerView
        rv_1 = rootView.findViewById(R.id.rv_1);
        rv_1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_1.setAdapter(staticRvAdapter2);

        items = new ArrayList<>();
        dynamicRV2Adapter = new DynamicRV2Adapter(items, getContext(), null); // pass appropriate context
        rv_2 = rootView.findViewById(R.id.rv_2);
        rv_2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rv_2.setAdapter(dynamicRV2Adapter);

        cart = rootView.findViewById(R.id.cart);
        cart.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            Fragment fragment = new ConfirmOrderFragment();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
        });

        return rootView;
    }

    // Initialize context in onAttach method
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = (Activity) context;
    }

    @Override
    public void callback(int position, ArrayList<DynamicRV2Model> items) {
        dynamicRV2Adapter.setItems(items);
        dynamicRV2Adapter.notifyDataSetChanged();
        rv_2.setAdapter(dynamicRV2Adapter);
    }

    @Override
    public void onItemClick(int position) {
        // Handle item click event from StaticRvAdapter2
        // You can implement navigation logic here to open another activity or perform any action
        Toast.makeText(getContext(), "Clicked on item at position: " + position, Toast.LENGTH_SHORT).show();
    }
}
