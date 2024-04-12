package com.example.sizzlingbitesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ManageAddressActivity extends AppCompatActivity {
    TextInputLayout newAddress;
    MaterialCardView update;
    FirebaseUser user;
    DatabaseReference mDatabase;
    TextView previousAddressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_address);
        newAddress = findViewById(R.id.newAddress);
        update = findViewById(R.id.update);
        previousAddressText = findViewById(R.id.previousAddressText);

        update.setOnClickListener(v -> {
           updateAddress();
        });
    }

    private void updateAddress() {
        String newAddressValue = newAddress.getEditText().getText().toString().trim();
        if (!newAddressValue.isEmpty()) {
            user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                String uid = user.getUid();
                mDatabase.child("Users").child(uid).child("address").setValue(newAddressValue)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                // Set the new address in the TextView
                                previousAddressText.setText(newAddressValue);

                                Toast.makeText(ManageAddressActivity.this, "Address updated successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ManageAddressActivity.this, MainActivity.class);
                                intent.putExtra("openSettingsFragment", true);
                                startActivity(intent);
                                finish(); // Close the activity after updating the address
                            } else {
                                Toast.makeText(ManageAddressActivity.this, "Failed to update address", Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                Toast.makeText(ManageAddressActivity.this, "User not authenticated", Toast.LENGTH_SHORT).show();
            }
        } else {
            newAddress.setError("Address cannot be empty");
        }
    }

}