package com.example.onlinepatientsupportsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class records extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText genderEditText;
    private EditText dobEditText;
    private EditText heightEditText;
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);

        // Initialize EditText and Button elements
        fullNameEditText = findViewById(R.id.editTextText4);
        genderEditText = findViewById(R.id.editTextText5);
        dobEditText = findViewById(R.id.editTextText6);
        heightEditText = findViewById(R.id.editTextText7);
        proceedButton = findViewById(R.id.proceedButton);

        // Set click listener for the Proceed button
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceedToSecondRecords();
            }
        });
    }

    private void proceedToSecondRecords() {
        // Get input data from EditText fields
        String fullName = fullNameEditText.getText().toString();
        String gender = genderEditText.getText().toString();
        String dob = dobEditText.getText().toString();
        String height = heightEditText.getText().toString();

        // Create an intent to navigate to the second records activity
        Intent intent = new Intent(this, records2.class);

        // Pass the input data to the second records activity
        intent.putExtra("FULL_NAME", fullName);
        intent.putExtra("GENDER", gender);
        intent.putExtra("DOB", dob);
        intent.putExtra("HEIGHT", height);

        // Start the second records activity
        startActivity(intent);
    }
}
