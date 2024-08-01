package com.example.onlinepatientsupportsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "OnlineSupport.db";
    private static final int DATABASE_VERSION = 3;

    // Records Table
    public static final String TABLE_NAME_RECORDS = "Records";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FULL_NAME = "full_name";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_HEIGHT = "height";
    public static final String COLUMN_CONDITION = "condition";
    public static final String COLUMN_MEDICINE_NAME = "medicine_name";
    public static final String COLUMN_PRESCRIPTION = "prescription";
    public static final String COLUMN_ADDITIONAL_INFO = "additional_info";

    // Homes Table
    public static final String TABLE_NAME_HOMES = "Homes";
    public static final String COLUMN_HOME_ID = "home_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_HOME_NAME = "home_name";

    // Messages Table
    public static final String TABLE_NAME_MESSAGES = "Messages";
    public static final String COLUMN_MESSAGE_ID = "message_id";
    public static final String COLUMN_MESSAGE_TEXT = "message_text";
    public static final String COLUMN_IS_SENT_BY_CURRENT_USER = "is_sent_by_current_user";

    public static final String TABLE_NAME_MEDICATIONS = "Medications";
    public static final String COLUMN_MEDICATION_ID = "medication_id";
    public static final String COLUMN_PATIENT_NAME = "patient_name";
    public static final String COLUMN_DRUG_NAME = "drug_name";
    public static final String COLUMN_DRUG_FORM = "drug_form";
    public static final String COLUMN_DOSAGE = "dosage";
    private static final String TABLE_CREATE_RECORDS =
            "CREATE TABLE " + TABLE_NAME_RECORDS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FULL_NAME + " TEXT, " +
                    COLUMN_GENDER + " TEXT, " +
                    COLUMN_DOB + " TEXT, " +
                    COLUMN_HEIGHT + " TEXT, " +
                    COLUMN_CONDITION + " TEXT, " +
                    COLUMN_MEDICINE_NAME + " TEXT, " +
                    COLUMN_PRESCRIPTION + " TEXT, " +
                    COLUMN_ADDITIONAL_INFO + " TEXT);";

    private static final String TABLE_CREATE_HOMES =
            "CREATE TABLE " + TABLE_NAME_HOMES + " (" +
                    COLUMN_HOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_HOME_NAME + " TEXT);";

    private static final String TABLE_CREATE_MESSAGES =
            "CREATE TABLE " + TABLE_NAME_MESSAGES + " (" +
                    COLUMN_MESSAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_MESSAGE_TEXT + " TEXT, " +
                    COLUMN_IS_SENT_BY_CURRENT_USER + " INTEGER);";

    private static final String TABLE_CREATE_MEDICATIONS =
            "CREATE TABLE " + TABLE_NAME_MEDICATIONS + " (" +
                    COLUMN_MEDICATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PATIENT_NAME + " TEXT, " +
                    COLUMN_DRUG_NAME + " TEXT, " +
                    COLUMN_DRUG_FORM + " TEXT, " +
                    COLUMN_DOSAGE + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_RECORDS);
        db.execSQL(TABLE_CREATE_HOMES);
        db.execSQL(TABLE_CREATE_MESSAGES);
        db.execSQL(TABLE_CREATE_MEDICATIONS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_RECORDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_HOMES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MESSAGES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MEDICATIONS);
        onCreate(db);
    }

    public long insertRecord(String fullName, String gender, String dob, String height, String condition, String medicineName, String prescription, String additionalInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FULL_NAME, fullName);
        values.put(COLUMN_GENDER, gender);
        values.put(COLUMN_DOB, dob);
        values.put(COLUMN_HEIGHT, height);
        values.put(COLUMN_CONDITION, condition);
        values.put(COLUMN_MEDICINE_NAME, medicineName);
        values.put(COLUMN_PRESCRIPTION, prescription);
        values.put(COLUMN_ADDITIONAL_INFO, additionalInfo);
        long newRowId = db.insert(TABLE_NAME_RECORDS, null, values);
        db.close();
        return newRowId;
    }

    public long insertMedication(String patientName, String drugName, String drugForm, String dosage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PATIENT_NAME, patientName);
        values.put(COLUMN_DRUG_NAME, drugName);
        values.put(COLUMN_DRUG_FORM, drugForm);
        values.put(COLUMN_DOSAGE, dosage);
        long newRowId = db.insert(TABLE_NAME_MEDICATIONS, null, values);
        db.close();
        return newRowId;
    }

    public Cursor getAllRecords() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME_RECORDS, null, null, null, null, null, null);
    }

    public long addHome(String name, String homeName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_HOME_NAME, homeName);
        long newRowId = db.insert(TABLE_NAME_HOMES, null, values);
        db.close();
        return newRowId;
    }

    public Cursor getAllHomes() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME_HOMES, null, null, null, null, null, null);
    }

    public Cursor getAllMedications() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME_MEDICATIONS, null, null, null, null, null, null);
    }
}