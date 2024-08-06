package com.example.onlinepatientsupportsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    private ImageView imageView19;
    private ImageView imageView18;
    private ImageView imageView22;
    private ImageView imageView23;
    private ImageView imageView24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Initialize ImageView elements
        imageView19 = findViewById(R.id.imageView19);
        imageView18 = findViewById(R.id.imageView18);
        imageView22 = findViewById(R.id.imageView22);
        imageView23 = findViewById(R.id.imageView23);
        imageView24 = findViewById(R.id.imageView24);

        // Set click listeners for each ImageView

        imageView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMedications();
            }
        });

        imageView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToRecords();
            }
        });

        imageView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLogin();
            }
        });

        imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMessaging();
            }
        });

        imageView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToViewRecords();
            }
        });
    }


    private void navigateToMedications() {
        Intent intent = new Intent(this, medications.class);
        startActivity(intent);
    }

    private void navigateToRecords() {
        Intent intent = new Intent(this, records.class);
        startActivity(intent);
    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    private void navigateToMessaging() {
        Intent intent = new Intent(this, Messaging.class);
        startActivity(intent);
    }

    private void navigateToViewRecords() {
        Intent intent = new Intent(this, ViewRecordsActivity.class);
        startActivity(intent);
    }
}
