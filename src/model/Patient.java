package model;

public class Patient {

    private int patientId;
    private String name;
    private int age;
    private String disease;
    private int doctorId;
    private double bill;
    private String password;

    public Patient() {}

    public Patient(int patientId, String name, int age, String disease, int doctorId, double bill, String password) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctorId = doctorId;
        this.bill = bill;
        this.password = password;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    
}