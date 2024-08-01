package com.example.onlinepatientsupportsystem;

public class Message {
    private String message;
    private boolean isSentByCurrentUser;

    public Message(String message, boolean isSentByCurrentUser) {
        this.message = message;
        this.isSentByCurrentUser = isSentByCurrentUser;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSentByCurrentUser() {
        return isSentByCurrentUser;
    }
}
