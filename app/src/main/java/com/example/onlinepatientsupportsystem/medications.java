package com.example.onlinepatientsupportsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class medications extends AppCompatActivity {

    private EditText patientNameEditText, drugNameEditText, drugFormEditText, dosageEditText;

    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medications);

        patientNameEditText = findViewById(R.id.patientName);
        drugNameEditText = findViewById(R.id.drugName);
        drugFormEditText = findViewById(R.id.drugForm);
        dosageEditText = findViewById(R.id.editTextText12);
        Button submitButton = findViewById(R.id.submit);
        Button viewmedicationsButton = findViewById(R.id.viewmedicationsButton);

        viewmedicationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(medications.this, viewmedications.class);
                startActivity(intent);
            }
        });
        databaseHelper = new DatabaseHelper(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMedication();
            }
        });
    }

    private void saveMedication() {
        String patientName = patientNameEditText.getText().toString().trim();
        String drugName = drugNameEditText.getText().toString().trim();
        String drugForm = drugFormEditText.getText().toString().trim();
        String dosage = dosageEditText.getText().toString().trim();

        if (patientName.isEmpty() || drugName.isEmpty() || drugForm.isEmpty() || dosage.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            long result = databaseHelper.insertMedication(patientName, drugName, drugForm, dosage);

            if (result != -1) {
                Toast.makeText(this, "Medication saved successfully", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(this, "Failed to save medication", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void clearFields() {
        patientNameEditText.setText("");
        drugNameEditText.setText("");
        drugFormEditText.setText("");
        dosageEditText.setText("");
    }
}
