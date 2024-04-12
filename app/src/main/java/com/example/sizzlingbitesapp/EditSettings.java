package com.example.sizzlingbitesapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditSettings extends AppCompatActivity {
    MaterialCardView update;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    TextInputLayout editphoneNo, editNewphoneNo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_settings_layout);
        update = findViewById(R.id.update);
        editphoneNo = findViewById(R.id.editphoneNo);
        editNewphoneNo = findViewById(R.id.editNewphoneNo);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance("https://sizzlingbites-f156a-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("users");

        update.setOnClickListener(v -> {

            checkPhoneNumber();
//            String phoneNo = editphoneNo.getText().toString();
//            String newPhoneNo = editNewphoneNo.getText().toString();
//            if (phoneNo.isEmpty() || newPhoneNo.isEmpty()) {
//                editphoneNo.setError("Please fill all the fields");
//                editNewphoneNo.setError("Please fill all the fields");
//            } else {
//                mDatabase.child(mAuth.getCurrentUser().getUid()).child("phoneNo").setValue(newPhoneNo);
//                finish();
//            }
        });



    }

    private void checkPhoneNumber() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String currentUserUid = user.getUid();
            String enteredPhoneNo = editphoneNo.getEditText().toString().trim();
            String newPhoneNo = editNewphoneNo.getEditText().toString().trim(); // Get the new phone number

            if (enteredPhoneNo.isEmpty() || newPhoneNo.isEmpty()) {
                editphoneNo.setError("Please fill all the fields");
                editNewphoneNo.setError("Please fill all the fields");
                return;
            } else if (enteredPhoneNo.length() != 10 || newPhoneNo.length() != 10) {
                editphoneNo.setError("Invalid phone number");
                editNewphoneNo.setError("Invalid phone number");
                return;
            }

            mDatabase.child(currentUserUid).child("phone").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String registeredPhoneNumber = snapshot.getValue(String.class);
                    if (registeredPhoneNumber != null && registeredPhoneNumber.equals(enteredPhoneNo)) {
                        // Phone number matches, update the phone number
                        mDatabase.child(currentUserUid).child("phone").setValue(newPhoneNo)
                                .addOnCompleteListener(task -> {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(EditSettings.this, "Phone number updated successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(EditSettings.this, MainActivity.class);
                                        intent.putExtra("openSettingsFragment", true);
                                        startActivity(intent);
                                        finish(); // Close the activity after updating the phone number
                                    } else {
                                        Toast.makeText(EditSettings.this, "Failed to update phone number", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        // Phone number does not match
                        Toast.makeText(EditSettings.this, "Phone number does not match!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(EditSettings.this, "Failed to check phone number: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            // User not authenticated
            Toast.makeText(EditSettings.this, "User not authenticated", Toast.LENGTH_SHORT).show();
        }
    }
}
