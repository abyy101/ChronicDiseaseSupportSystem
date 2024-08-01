package com.example.onlinepatientsupportsystem;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class viewmedications extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private TextView viewPatientName, viewDrugName, viewDrugForm, viewDosage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewmedications);

        // Initialize views
        viewPatientName = findViewById(R.id.viewpatientName);
        viewDrugName = findViewById(R.id.viewdrugName);
        viewDrugForm = findViewById(R.id.viewdrugForm);
        viewDosage = findViewById(R.id.viewDosage);
        Button medButton = findViewById(R.id.medButton);
        dbHelper = new DatabaseHelper(this);
        displayMedications();

        medButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewmedications.this, medications.class);
                startActivity(intent);
            }
        });
    }

    private void displayMedications() {// to display the medications in the record table.
        Cursor cursor = dbHelper.getAllMedications();
        if (cursor != null && cursor.moveToFirst()) {
            StringBuilder patientNames = new StringBuilder();
            StringBuilder drugNames = new StringBuilder();
            StringBuilder drugForms = new StringBuilder();
            StringBuilder dosages = new StringBuilder();

            do {
                patientNames.append(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PATIENT_NAME))).append("\n");
                drugNames.append(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DRUG_NAME))).append("\n");
                drugForms.append(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DRUG_FORM))).append("\n");
                dosages.append(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DOSAGE))).append("\n");
            } while (cursor.moveToNext());

            viewPatientName.setText(patientNames.toString());
            viewDrugName.setText(drugNames.toString());
            viewDrugForm.setText(drugForms.toString());
            viewDosage.setText(dosages.toString());
        }
        if (cursor != null) {
            cursor.close();
        }
    }
}
