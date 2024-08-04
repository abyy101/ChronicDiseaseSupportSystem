package com.example.onlinepatientsupportsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class home2 extends AppCompatActivity {

    private ImageView imageView18;
    private ImageView imageView20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);

        imageView18 = findViewById(R.id.imageView18);
        imageView20 = findViewById(R.id.imageView20);

        imageView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessagingPage();
            }
        });

        imageView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFindHomeActivity();
            }
        });
    }

    private void openMessagingPage() {
        Intent intent = new Intent(this, SecondMessaging.class);
        startActivity(intent);
    }

    private void openFindHomeActivity() {
        Intent intent = new Intent(this, findhome.class);
        startActivity(intent);
    }
}
