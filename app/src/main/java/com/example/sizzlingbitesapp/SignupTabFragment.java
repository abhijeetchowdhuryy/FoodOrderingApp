package com.example.sizzlingbitesapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignupTabFragment extends Fragment {

    EditText email, password, confirmPassword, mobile, name;
    FirebaseAuth auth;
    ProgressDialog progressDialog;
    MaterialCardView signup;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.signup_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        confirmPassword = root.findViewById(R.id.confirmPassword);
        mobile = root.findViewById(R.id.mobile);
        signup = root.findViewById(R.id.signup);
        name = root.findViewById(R.id.username);
        auth = FirebaseAuth.getInstance();

        signup.setOnClickListener(v -> {
            String nameText = name.getText().toString();
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();
            String confirmPasswordText = confirmPassword.getText().toString();
            String mobileText = mobile.getText().toString();

            if (TextUtils.isEmpty(nameText) || TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText) || TextUtils.isEmpty(confirmPasswordText)) {
                name.setError("Please fill all the fields");
                email.setError("Please fill all the fields");
                mobile.setError("Please fill all the fields");
                password.setError("Please fill all the fields");
                confirmPassword.setError("Please fill all the fields");
            } else if (!passwordText.equals(confirmPasswordText)) {
                confirmPassword.setError("Password does not match");
            } else if (passwordText.length() < 6) {
                password.setError("Password must be at least 6 characters");
            } else {
                progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage("Please wait...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                signup.setEnabled(false);
                registerUser(nameText, emailText, passwordText, mobileText);
            }
        });

        return root;
    }

    @SuppressLint("ResourceType")
    private void registerUser(String nameText, String emailText, String passwordText, String mobileText) {
        auth.createUserWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(auth.getCurrentUser().getUid());
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("id", auth.getCurrentUser().getUid());
                hashMap.put("name", nameText);
                hashMap.put("email", emailText);
                hashMap.put("password", passwordText);
                hashMap.put("imageURL", "default");
                hashMap.put("phone", mobileText);
                hashMap.put("address", "");
                hashMap.put("institution", "");
                hashMap.put("job", "");
                hashMap.put("github", "");
                hashMap.put("linkedin", "");
                reference.setValue(hashMap).addOnCompleteListener(task1 -> {
                    if (task1.isSuccessful()) {
                        progressDialog.dismiss();
                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("name", nameText);
                        editor.apply();

                        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("MyPrefs2", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                        editor2.putString("mobile", mobileText);
                        editor2.apply();


                        Toast.makeText(getActivity(), "Welcome", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    } else {
                        Toast.makeText(getActivity(), "Registration Failed", Toast.LENGTH_SHORT).show();
                        auth.signOut();
                    }
                });
            } else {
                progressDialog.dismiss();
                signup.setEnabled(true);
                Toast.makeText(getContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
