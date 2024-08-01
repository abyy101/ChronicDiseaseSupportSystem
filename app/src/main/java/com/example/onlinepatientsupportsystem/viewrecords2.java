package com.example.onlinepatientsupportsystem;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class viewrecords2 extends AppCompatActivity {

    private TableLayout tableLayoutRecords;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewrecords2);

        tableLayoutRecords = findViewById(R.id.tableLayoutRecords);
        dbHelper = new DatabaseHelper(this);

        loadRecords();
    }

    private void loadRecords() {
        Cursor cursor = dbHelper.getAllRecords(); // Ensure this method is for fetching medication data
        if (cursor.moveToFirst()) {
            do {
                TableRow tableRow = new TableRow(this);
                TableRow.LayoutParams params = new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT,
                        1.0f
                );

                // Initialize and configure TextViews to match the headers
                TextView condition = new TextView(this);
                TextView medicineName = new TextView(this);
                TextView prescription = new TextView(this);
                TextView additionalInfo = new TextView(this);

                condition.setLayoutParams(params);
                condition.setPadding(10, 10, 10, 10);
                condition.setGravity(Gravity.CENTER_HORIZONTAL);
                condition.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CONDITION)));

                medicineName.setLayoutParams(params);
                medicineName.setPadding(10, 10, 10, 10);
                medicineName.setGravity(Gravity.CENTER_HORIZONTAL);
                medicineName.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_MEDICINE_NAME)));

                prescription.setLayoutParams(params);
                prescription.setPadding(10, 10, 10, 10);
                prescription.setGravity(Gravity.CENTER_HORIZONTAL);
                prescription.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRESCRIPTION)));

                additionalInfo.setLayoutParams(params);
                additionalInfo.setPadding(10, 10, 10, 10);
                additionalInfo.setGravity(Gravity.CENTER_HORIZONTAL);
                additionalInfo.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ADDITIONAL_INFO)));

                // Add TextViews to TableRow
                tableRow.addView(condition);
                tableRow.addView(medicineName);
                tableRow.addView(prescription);
                tableRow.addView(additionalInfo);

                // Add TableRow to TableLayout
                tableLayoutRecords.addView(tableRow);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}

