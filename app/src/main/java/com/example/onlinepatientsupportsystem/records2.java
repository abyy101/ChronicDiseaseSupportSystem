package com.example.onlinepatientsupportsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class records2 extends AppCompatActivity {

    private EditText conditionEditText;
    private EditText medicineNameEditText;
    private EditText prescriptionEditText;
    private EditText additionalInfoEditText;
    private Button submitButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records2);

        // Initialize EditText and Button elements
        conditionEditText = findViewById(R.id.editTextText4);
        medicineNameEditText = findViewById(R.id.editTextText5);
        prescriptionEditText = findViewById(R.id.editTextText6);
        additionalInfoEditText = findViewById(R.id.editTextText7);
        submitButton = findViewById(R.id.submitbutton);

        // Initialize database helper
        dbHelper = new DatabaseHelper(this);

        // Set click listener for the Submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    private void saveData() {
        // Retrieve data from FirstRecordsActivity
        String fullName = getIntent().getStringExtra("FULL_NAME");
        String gender = getIntent().getStringExtra("GENDER");
        String dob = getIntent().getStringExtra("DOB");
        String height = getIntent().getStringExtra("HEIGHT");

        // Get input data from EditText fields in this activity
        String condition = conditionEditText.getText().toString();
        String medicineName = medicineNameEditText.getText().toString();
        String prescription = prescriptionEditText.getText().toString();
        String additionalInfo = additionalInfoEditText.getText().toString();

        // Save data to the database
        long newRowId = dbHelper.insertRecord(fullName, gender, dob, height, condition, medicineName, prescription, additionalInfo);

        // Check if data is saved successfully
        if (newRowId != -1) {
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
            // Optionally, clear the EditText fields after saving
            conditionEditText.setText("");
            medicineNameEditText.setText("");
            prescriptionEditText.setText("");
            additionalInfoEditText.setText("");
        } else {
            Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show();
        }
    }
}
