package com.example.sizzlingbitesapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginTabFragment extends Fragment {

    EditText email, password;
    TextView forgotPassword;
    MaterialCardView login;
    float v = 0;
    FirebaseAuth auth;

    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Check if user is already logged in
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            // User is already logged in, redirect to MainActivity
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish(); // Finish the current activity to prevent going back to it using back button
        }

        // If user is not logged in, continue with login process
        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        forgotPassword = root.findViewById(R.id.forgotpass);
        login = root.findViewById(R.id.login);
        progressDialog = new ProgressDialog(getActivity());

        // Animation code
        email.setTranslationX(800);
        password.setTranslationX(800);
        forgotPassword.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        forgotPassword.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        login.setOnClickListener(v -> {
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            if(TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText))
            {
                Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                progressDialog.setMessage("Logging in...");
                progressDialog.show();
                loginUser(emailText, passwordText);
            }
        });

        return root;
    }

    @SuppressLint("ResourceType")
    private void loginUser(String emailText, String passwordText) {
        auth.signInWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(task -> {
            progressDialog.dismiss();
            if(task.isSuccessful())
            {
                Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                // Redirect to DashboardFragment upon successful login
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish(); // Finish the current activity to prevent going back to it using back button
            } else {
                Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
