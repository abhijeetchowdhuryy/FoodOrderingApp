package com.example.sizzlingbitesapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar; // Importing the correct Toolbar class
import androidx.fragment.app.Fragment;

import com.example.sizzlingbitesapp.R;
import com.google.android.material.card.MaterialCardView;

public class PaymentFragment extends Fragment {

    MaterialCardView paytm, google_pay, phonepe, bharatpe, cod;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_payment, container, false);

        paytm = root.findViewById(R.id.paytm);
        google_pay = root.findViewById(R.id.google_pay);
        phonepe = root.findViewById(R.id.phonepe);
        bharatpe = root.findViewById(R.id.bharatpe);
        cod = root.findViewById(R.id.cod);

        Toolbar toolbar = root.findViewById(R.id.toolbar);
        toolbar.setTitle("Payment Options");
        toolbar.setNavigationOnClickListener(view -> {
            requireActivity().onBackPressed(); // Navigate back
        });

        double totalAmount = getArguments().getDouble("totalAmount", 0);

        paytm.setOnClickListener(v -> openPaymentApp("paytm", totalAmount));
        google_pay.setOnClickListener(v -> openPaymentApp("googlepay", totalAmount));
        phonepe.setOnClickListener(v -> openPaymentApp("phonepe", totalAmount));
        bharatpe.setOnClickListener(v -> openPaymentApp("bharatpe", totalAmount));

        cod.setOnClickListener(v -> {
            // Navigate to OrderPlacedFragment
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new CODFragment()).commit();
        });

        return root;
    }

    private void openPaymentApp(String app, double amount) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (app.equals("paytm")) {
            // For Paytm
            intent.setData(Uri.parse("upi://pay?pa=abhijeetchowdhury771@okhdfcbank&pn=Abhijeet%20Chowdhury&am=" + amount + "&cu=INR"));
            intent.setPackage("net.one97.paytm");
        } else if (app.equals("googlepay")) {
            // For Google Pay
            intent.setData(Uri.parse("upi://pay?pa=abhijeetchowdhury771@okhdfcbank&pn=Abhijeet%20Chowdhury&am=" + amount + "&cu=INR"));
            intent.setPackage("com.google.android.apps.nbu.paisa.user");
        } else if (app.equals("phonepe")) {
            // For PhonePe
            intent.setData(Uri.parse("upi://pay?pa=phonepe@ybl&pn=Abhijeet%20Chowdhury&am=" + amount + "&cu=INR"));
            intent.setPackage("com.phonepe.app");
        } else if (app.equals("bharatpe")) {
            // For BharatPe
            intent.setData(Uri.parse("upi://pay?pa=merchant@bharatpe&pn=Abhijeet%20Chowdhury&am=" + amount + "&cu=INR"));
            intent.setPackage("com.bharatpe");
        }
        startActivity(intent);
    }
}
