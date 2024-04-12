package com.example.sizzlingbitesapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sizzlingbitesapp.DashBoardFragment;
import com.example.sizzlingbitesapp.R;
import com.google.android.material.card.MaterialCardView;

public class CODFragment extends Fragment {

    MaterialCardView dashboardButton;
    ImageView instagram, facebook, twitter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.cod_fragment, container, false);

        dashboardButton = root.findViewById(R.id.dashboardButton);
        instagram = root.findViewById(R.id.instagram);
        facebook = root.findViewById(R.id.facebook);
        twitter = root.findViewById(R.id.twitter);

        Toolbar toolbar = root.findViewById(R.id.toolbar);
        toolbar.setTitle("Order Placed");
        toolbar.setNavigationOnClickListener(view -> {
            requireActivity().onBackPressed(); // Navigate back
        });

        dashboardButton.setOnClickListener(v -> {
            // Navigate to DashboardFragment
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new DashBoardFragment()).commit();
        });

        // Open Instagram when clicked
        instagram.setOnClickListener(v -> openInstagram());

        // Open Facebook when clicked
        facebook.setOnClickListener(v -> openFacebook());

        // Open Twitter when clicked
        twitter.setOnClickListener(v -> openTwitter());

        return root;
    }

    private void openInstagram() {
        Uri uri = Uri.parse("http://instagram.com/_uppercase_guy_");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.instagram.android");

        // Check if Instagram app is installed
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // If Instagram app is not installed, open Instagram in a web browser
            intent.setData(Uri.parse("http://instagram.com/_uppercase_guy_"));
            startActivity(intent);
        }
    }

    private void openFacebook() {
        Uri uri = Uri.parse("https://www.facebook.com/abhijeet.chowdhury.33/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void openTwitter() {
        String twitterUser = "Mr____killer";
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + twitterUser)));
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + twitterUser)));
        }
    }
}
