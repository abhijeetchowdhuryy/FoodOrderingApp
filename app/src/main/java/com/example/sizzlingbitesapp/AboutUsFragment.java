package com.example.sizzlingbitesapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sizzlingbitesapp.R;

public class AboutUsFragment extends Fragment {
    LottieAnimationView quote, quote2, insta, facebook, twitter, sizzling;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.about_us_fragment, container, false);
        quote = root.findViewById(R.id.quote);
        quote2 = root.findViewById(R.id.quote2);
        insta = root.findViewById(R.id.insta);
        facebook = root.findViewById(R.id.facebook);
        sizzling = root.findViewById(R.id.sizzling);
        twitter = root.findViewById(R.id.twitter);
        quote2.setVisibility(View.INVISIBLE);
        insta.setVisibility(View.INVISIBLE);
        facebook.setVisibility(View.INVISIBLE);
        sizzling.setVisibility(View.INVISIBLE);
        twitter.setVisibility(View.INVISIBLE);
        insta.setMaxFrame(60);
        facebook.setMaxFrame(60);
        twitter.setMaxFrame(60);


        // Start quote animation with a delay of 5 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                quote.playAnimation();
            }
        }, 5000); // 5000 milliseconds = 5 seconds delay

        // Listen for animation updates to determine when quote animation finishes
        quote.addAnimatorUpdateListener(animation -> {
            if (animation.getAnimatedFraction() >= 1f) {
                // When quote animation finishes, start quote2 animation
                quote2.setVisibility(View.VISIBLE);
                quote2.playAnimation();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insta.setVisibility(View.VISIBLE);
                insta.playAnimation();
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                facebook.setVisibility(View.VISIBLE);
                facebook.playAnimation();
            }
        }, 4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twitter.setVisibility(View.VISIBLE);
                twitter.playAnimation();
            }
        }, 5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sizzling.setVisibility(View.VISIBLE);
                sizzling.playAnimation();
                sizzling.addAnimatorUpdateListener(animation -> {
                    if (animation.getAnimatedFraction() >= 1f) {
                        sizzling.setVisibility(View.INVISIBLE);
                    }
                });

            }
        }, 6500);

        insta.setOnClickListener(v -> {
            // Open Instagram page
            openInstagramProfile(); 
        });

        facebook.setOnClickListener(v -> {
            // Open Facebook page
            openFacebookProfile();
        });

        twitter.setOnClickListener(v -> {
            // Open Twitter page
            openTwitterProfile();
        });

        return root;
    }

    private void openInstagramProfile() {
        {
            String instagramProfile = "_uppercase_guy_"; // Change this to your Instagram handle
            Uri uri = Uri.parse("http://instagram.com/_u/" + instagramProfile);
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (android.content.ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/" + instagramProfile)));
            }
        }
    }

    private void openFacebookProfile() {
        String facebookProfile = "abhijeet.chowdhury.33"; // Change this to your Facebook username
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/" + facebookProfile));
            startActivity(intent);
        } catch (Exception e) {
            // Facebook app isn't installed, open in browser
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + facebookProfile));
            startActivity(intent);
        }
    }

    private void openTwitterProfile() {
        String twitterUsername = "Mr____killer"; // Change this to your Twitter username
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + twitterUsername)));
        } catch (Exception e) {
            // Twitter app isn't installed, open in browser
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + twitterUsername)));
        }
    }
}
