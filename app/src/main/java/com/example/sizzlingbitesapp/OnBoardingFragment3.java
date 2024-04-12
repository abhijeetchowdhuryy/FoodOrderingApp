package com.example.sizzlingbitesapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OnBoardingFragment3 extends Fragment {

//    FloatingActionButton next;

    LottieAnimationView lottieAnimationView;

    TextView textView3;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_on_boarding3, container, false);

        lottieAnimationView = root.findViewById(R.id.next);
        textView3 = root.findViewById(R.id.textView3);
        imageView = root.findViewById(R.id.imageView);

        //set repeat count as infinite
        lottieAnimationView.setRepeatCount(1000);


        lottieAnimationView.setOnClickListener(view -> {
            // go to next activity
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

        return root;
    }
}
