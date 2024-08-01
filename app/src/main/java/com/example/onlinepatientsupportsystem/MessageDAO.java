package com.example.onlinepatientsupportsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    private DatabaseHelper dbHelper;

    public MessageDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void insertMessage(Message message) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_MESSAGE_TEXT, message.getMessage());
        values.put(DatabaseHelper.COLUMN_IS_SENT_BY_CURRENT_USER, message.isSentByCurrentUser() ? 1 : 0);
        db.insert(DatabaseHelper.TABLE_NAME_MESSAGES, null, values);
        db.close();
    }

    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME_MESSAGES, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String messageText = getColumnValueString(cursor, DatabaseHelper.COLUMN_MESSAGE_TEXT);
                boolean isSentByCurrentUser = getColumnValue(cursor, DatabaseHelper.COLUMN_IS_SENT_BY_CURRENT_USER) == 1;
                messages.add(new Message(messageText, isSentByCurrentUser));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return messages;
    }


    private int getColumnValue(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex != -1) {
            return cursor.getInt(columnIndex);
        } else {
            throw new IllegalArgumentException("Column " + columnName + " does not exist");
        }
    }

    private String getColumnValueString(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex != -1) {
            return cursor.getString(columnIndex);
        } else {
            throw new IllegalArgumentException("Column " + columnName + " does not exist");
        }
    }
}
