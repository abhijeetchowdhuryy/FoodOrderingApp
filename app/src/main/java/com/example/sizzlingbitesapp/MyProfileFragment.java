package com.example.sizzlingbitesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MyProfileFragment extends Fragment {

    TextInputLayout name, email, phone, password;
    FirebaseUser firebaseUser;

    TextView fullNameLabel, usernameLabel;

    LottieAnimationView profile_image;

    MaterialCardView update;

    String user_username, user_name, user_email, user_phoneNo, user_password;

    DatabaseReference reference;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.my_profile_fragment, container, false);
        reference = FirebaseDatabase.getInstance("https://sizzlingbites-f156a-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("users");

        //Hooks
        name = root.findViewById(R.id.name);
        email = root.findViewById(R.id.email);
        phone = root.findViewById(R.id.phone);
        password = root.findViewById(R.id.password);
        fullNameLabel = root.findViewById(R.id.fullNameLabel);
        profile_image = root.findViewById(R.id.profile_image);
        update = root.findViewById(R.id.update);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // Retrieve other user data and display
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("name", "");
        fullNameLabel.setText(userName);

        update.setOnClickListener(v -> {
            final String newName = name.getEditText().getText().toString().trim();
            final String newEmail = email.getEditText().getText().toString().trim();
            final String newPhone = phone.getEditText().getText().toString().trim();
            final String newPassword = password.getEditText().getText().toString().trim();

            // Check if any field is empty
            if (newName.isEmpty() || newEmail.isEmpty() || newPhone.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return; // Exit the method if any field is empty
            }

            // Check if new values are same as previous values
            if (newName.equals(user_name) && newEmail.equals(user_email) && newPhone.equals(user_phoneNo) && newPassword.equals(user_password)) {
                Toast.makeText(requireContext(), "Values entered are same as before", Toast.LENGTH_SHORT).show();
                return; // Exit the method if values are same as before
            }

            // Update the name in the UI
            fullNameLabel.setText(newName);

            // Update the data in Firebase
            reference.child(firebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("name", newName);
                    hashMap.put("email", newEmail);
                    hashMap.put("phoneNo", newPhone);
                    hashMap.put("password", newPassword);
                    reference.child(firebaseUser.getUid()).updateChildren(hashMap);

                    Toast.makeText(requireContext(), "Profile updated successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(requireContext(), "Failed to update profile", Toast.LENGTH_SHORT).show();
                }
            });
        });


        return root;
    }
}
