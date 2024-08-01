package com.example.onlinepatientsupportsystem;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewRecordsActivity extends AppCompatActivity {

    private TableLayout tableLayoutRecords;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewrecords);

        tableLayoutRecords = findViewById(R.id.tableLayoutRecords);
        dbHelper = new DatabaseHelper(this);

        Button nextButton = findViewById(R.id.nextButton);

        loadRecords();

            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ViewRecordsActivity.this, viewrecords2.class);
                    startActivity(intent);
                }
            });
    }



    private void loadRecords() {
        Cursor cursor = dbHelper.getAllRecords();
        if (cursor.moveToFirst()) {
            do {
                TableRow tableRow = new TableRow(this);
                TableRow.LayoutParams params = new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT,
                        1.0f
                );

                TextView fullName = new TextView(this);
                TextView gender = new TextView(this);
                TextView dob = new TextView(this);
                TextView height = new TextView(this);

                // Set width, padding, and gravity to match headers
                fullName.setLayoutParams(params);
                fullName.setPadding(10, 10, 10, 10);
                fullName.setGravity(Gravity.CENTER_HORIZONTAL);
                fullName.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_FULL_NAME)));

                gender.setLayoutParams(params);
                gender.setPadding(10, 10, 10, 10);
                gender.setGravity(Gravity.CENTER_HORIZONTAL);
                gender.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_GENDER)));

                dob.setLayoutParams(params);
                dob.setPadding(10, 10, 10, 10);
                dob.setGravity(Gravity.CENTER_HORIZONTAL);
                dob.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DOB)));

                height.setLayoutParams(params);
                height.setPadding(10, 10, 10, 10);
                height.setGravity(Gravity.CENTER_HORIZONTAL);
                height.setText(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_HEIGHT)));

                tableRow.addView(fullName);
                tableRow.addView(gender);
                tableRow.addView(dob);
                tableRow.addView(height);

                tableLayoutRecords.addView(tableRow);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
