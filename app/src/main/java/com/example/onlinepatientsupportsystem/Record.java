package com.example.onlinepatientsupportsystem;

public class Record {

    private String fullName;
    private String gender;
    private String dob;
    private String height;
    private String condition;
    private String medicineName;
    private String prescription;
    private String additionalInfo;

    public Record(String fullName, String gender, String dob, String height,String condition, String medicineName, String prescription, String additionalInfo) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.height = height;
        this.condition = condition;
        this.medicineName = medicineName;
        this.prescription = prescription;
        this.additionalInfo = additionalInfo;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getHeight() {
        return height;
    }

    public String getCondition() {
        return condition;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getPrescription() {
        return prescription;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }
}
