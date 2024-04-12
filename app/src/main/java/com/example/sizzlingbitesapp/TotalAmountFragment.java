//package com.example.sizzlingbitesapp;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.widget.Toolbar;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.sizzlingbitesapp.ConfirmOrderActivityAdapter;
//import com.example.sizzlingbitesapp.PaymentFragment;
//import com.example.sizzlingbitesapp.R;
//import com.example.sizzlingbitesapp.TotalOrderFragmentAdapter;
//import com.example.sizzlingbitesapp.UpdateSelectedItems;
//import com.google.android.material.card.MaterialCardView;
//import java.util.ArrayList;
//
//public class TotalAmountFragment extends Fragment {
//
//    RecyclerView totalOrderRv;
//    MaterialCardView makePayment;
//    TextView subtotal_amount, tax_amount, total_amount;
//    TotalOrderFragmentAdapter totalOrderFragmentAdapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_total_amount, container, false);
//
//        subtotal_amount = root.findViewById(R.id.subtotal_amount);
//        tax_amount = root.findViewById(R.id.tax_amount);
//        total_amount = root.findViewById(R.id.total_amount);
//        makePayment = root.findViewById(R.id.Button2);
//        totalOrderRv = root.findViewById(R.id.totalOrderRv);
//        Toolbar toolbar = root.findViewById(R.id.toolbar);
//        toolbar.setTitle("Confirm Order");
//        toolbar.setNavigationOnClickListener(view -> {
//            requireActivity().onBackPressed(); // Navigate back
//        });
//
//        // Set up RecyclerView
//        totalOrderFragmentAdapter = new TotalOrderFragmentAdapter((ArrayList<OrderListModel>) ((UpdateSelectedItems) requireActivity()).getItems2(), requireActivity());
//        totalOrderRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        totalOrderRv.setAdapter(totalOrderFragmentAdapter);
//
//        // Calculate and set total amount
//        calculateAndSetTotalAmount();
//
//        makePayment.setOnClickListener(view -> {
//            // Pass total amount to PaymentFragment
//            Bundle bundle = new Bundle();
//            bundle.putDouble("totalAmount", Double.parseDouble(total_amount.getText().toString()));
//            PaymentFragment paymentFragment = new PaymentFragment();
//            paymentFragment.setArguments(bundle);
//
//            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, paymentFragment).commit();
//        });
//
//        return root;
//    }
//
//    // Calculate and set total amount method
//    // Calculate and set total amount method
//    private void calculateAndSetTotalAmount() {
//        // Retrieve the total amount from ConfirmOrderActivityAdapter
//        double subtotal = ((ConfirmOrderActivityAdapter) totalOrderRv.getAdapter()).getTotalAmount();
//
//        // Calculate tax amount (18% of subtotal)
//        double tax = 0.18 * subtotal;
//
//        // Calculate total amount (subtotal + tax)
//        double total = subtotal + tax;
//
//        // Set values to respective TextViews
//        subtotal_amount.setText(String.valueOf(subtotal));
//        tax_amount.setText(String.valueOf(tax));
//        total_amount.setText(String.valueOf(total));
//    }
//}
