package com.example.onlinepatientsupportsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class findhome extends AppCompatActivity {

    private static final String TAG = "findhome";

    EditText editTextFullName, editTextHomeName;
    DatabaseHelper databaseHelper;
    Button enrollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findhome);

        editTextFullName = findViewById(R.id.editTextText2);
        editTextHomeName = findViewById(R.id.editTextText3);
        enrollButton = findViewById(R.id.enrollbutton);
        databaseHelper = new DatabaseHelper(this);

        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData(v);
            }
        });
    }

    public void saveData(View view) {
        Log.d(TAG, "saveData method called");

        String fullName = editTextFullName.getText().toString().trim();
        String homeName = editTextHomeName.getText().toString().trim();

        if (fullName.isEmpty() || homeName.isEmpty()) {
            Toast.makeText(this, "Please enter both full name and home name", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Empty fields: fullName=" + fullName + ", homeName=" + homeName);
            return;
        }

        // Save data to the database
        long newRowId = databaseHelper.addHome(fullName, homeName);
        if (newRowId == -1) {
            Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Error saving data");
        } else {
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Data saved successfully: Row ID=" + newRowId);
            // Optionally, you can clear the EditText fields after saving
            editTextFullName.setText("");
            editTextHomeName.setText("");
        }
    }
}
