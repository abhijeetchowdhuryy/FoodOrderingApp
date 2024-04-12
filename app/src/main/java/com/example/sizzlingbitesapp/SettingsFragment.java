package com.example.sizzlingbitesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsFragment extends Fragment {

    RelativeLayout logout, manageAddress, paymentSetting, favourites, orderHistory, offers, refferals, privacyPolicy;
    TextView phoneNo;
    MaterialCardView edit;
    FirebaseAuth mAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.settings_fragment, container, false);
        logout = root.findViewById(R.id.logout);
        phoneNo = root.findViewById(R.id.phoneNo);
        edit = root.findViewById(R.id.edit);
        manageAddress = root.findViewById(R.id.manageAddress);
        paymentSetting = root.findViewById(R.id.paymentSetting);
        favourites = root.findViewById(R.id.favourites);
        orderHistory = root.findViewById(R.id.orderHistory);
        offers = root.findViewById(R.id.offers);
        refferals = root.findViewById(R.id.refferals);
        mAuth = FirebaseAuth.getInstance();
        privacyPolicy = root.findViewById(R.id.privacyPolicy);

        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("MyPrefs2", Context.MODE_PRIVATE);
        String mobileNumber = sharedPreferences2.getString("mobile", "");
        phoneNo.setText(mobileNumber);

        edit.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EditSettings.class);
            startActivity(intent);
        });

        manageAddress.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ManageAddressActivity.class);
            startActivity(intent);
        });

        logout.setOnClickListener(v -> {
            // Logout
            mAuth.signOut();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

        privacyPolicy.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PrivacyPolicyActivity.class);
            startActivity(intent);
        });
        return root;
    }
}
