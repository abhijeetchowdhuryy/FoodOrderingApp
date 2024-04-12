package com.example.sizzlingbitesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import com.google.android.material.card.MaterialCardView;

public class PrivacyPolicyActivity extends AppCompatActivity {

    MaterialCardView agree;
    RadioButton terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        agree = findViewById(R.id.agree);
        terms = findViewById(R.id.terms);

        agree.setOnClickListener(v -> {
            if (terms.isChecked()) {
                Intent intent = new Intent(PrivacyPolicyActivity.this, MainActivity.class);
                intent.putExtra("openSettingsFragment", true);
                startActivity(intent);
                finish();
            } else {
                terms.setError("Please agree to the terms and conditions");
            }
        });
    }
}