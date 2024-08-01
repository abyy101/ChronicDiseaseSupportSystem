package com.example.onlinepatientsupportsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SecondMessaging extends AppCompatActivity {

    private EditText editTextMessage;
    private Button buttonSend;
    private RecyclerView recyclerViewMessages;
    private MessageAdapter messageAdapter;
    private List<Message> messageList;
    private MessageDAO messageDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_message);

        messageDAO = new MessageDAO(this);

        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);

        messageList = messageDAO.getAllMessages();
        messageAdapter = new MessageAdapter(messageList);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(messageAdapter);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if (message != null) {
            Message receivedMessage = new Message(message, false);
            messageDAO.insertMessage(receivedMessage);
            messageList.add(receivedMessage);
            messageAdapter.notifyDataSetChanged();
        }

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                if (!message.isEmpty()) {
                    Message newMessage = new Message(message, true);
                    messageDAO.insertMessage(newMessage);
                    messageList.add(newMessage);
                    messageAdapter.notifyDataSetChanged();
                    editTextMessage.setText("");

                    Intent intent = new Intent(SecondMessaging.this, Messaging.class);
                    intent.putExtra("message", message);
                    startActivity(intent);
                }
            }
        });
    }
}
