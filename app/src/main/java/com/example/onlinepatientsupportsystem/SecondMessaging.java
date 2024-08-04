package com.example.onlinepatientsupportsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondMessaging extends AppCompatActivity {

    private EditText editTextMessage;
    private Button buttonSend;
    private TextView textMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_message);

        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        textMsg = findViewById(R.id.textMsg);

        // Receive the message from the first activity
        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");
        textMsg.setText(message);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String responseMessage = editTextMessage.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("RESPONSE_MESSAGE", responseMessage);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
