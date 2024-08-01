package com.example.onlinepatientsupportsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    // Hardcoded credentials for simplicity
    private static final String CORRECT_EMAIL = "abigaelwambuiw@gmail.com";
    private static final String CORRECT_PASSWORD = "1234";

    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Initialize EditText fields
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
    }

    // Method called when the Login button is clicked
    public void login(View view) {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Check if email and password match the hardcoded credentials
        if (email.equals(CORRECT_EMAIL) && password.equals(CORRECT_PASSWORD)) {
            // Successful login, navigate to home page or next activity
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
            finish(); // Prevent returning to the login screen with back button
        } else {
            // Display a message indicating login failure
            Toast.makeText(this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
