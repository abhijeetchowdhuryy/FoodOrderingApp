package com.example.sizzlingbitesapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbitesapp.ConfirmOrderActivityAdapter;
import com.example.sizzlingbitesapp.DynamicRV2Adapter;
import com.example.sizzlingbitesapp.OnItemClickListener;
import com.example.sizzlingbitesapp.OrderListModel;
import com.example.sizzlingbitesapp.PaymentFragment;
import com.example.sizzlingbitesapp.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class ConfirmOrderFragment extends Fragment implements OnItemClickListener, DynamicRV2Adapter.UpdateSelectedItems {

    RecyclerView orderRv;
    MaterialCardView confirmOrder;
    ConfirmOrderActivityAdapter confirmOrderActivityAdapter;
    ArrayList<OrderListModel> orderListModels;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_confirm_order, container, false);

        Toolbar toolbar = root.findViewById(R.id.toolbar);
        toolbar.setTitle("Your Orders");

        toolbar.setNavigationOnClickListener(view -> {
            requireActivity().onBackPressed();
        });

        orderListModels = new ArrayList<>();

        orderRv = root.findViewById(R.id.order_rv);
        confirmOrderActivityAdapter = new ConfirmOrderActivityAdapter(orderListModels, requireActivity());
        orderRv.setLayoutManager(new LinearLayoutManager(getContext()));
        orderRv.setAdapter(confirmOrderActivityAdapter);

        confirmOrder = root.findViewById(R.id.confirmOrder);
        confirmOrder.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PaymentFragment()).commit();
        });

        return root;
    }

    @Override
    public void addItems(String name, int price) {
        orderListModels.add(new OrderListModel(name, price, 1));
        confirmOrderActivityAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(String name, int price) {
        orderListModels.add(new OrderListModel(name, price, 1));
        confirmOrderActivityAdapter.notifyDataSetChanged();
    }
}
