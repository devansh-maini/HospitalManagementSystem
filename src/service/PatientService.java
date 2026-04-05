package service;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PatientService {

    public void addPatient() {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            sc.nextLine();

            System.out.print("Disease: ");
            String disease = sc.nextLine();

            System.out.print("Doctor ID: ");
            int doctorId = sc.nextInt();

            System.out.print("Bill: ");
            double bill = sc.nextDouble();

            sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO patient(name,age,disease,doctor_id,bill,password) VALUES(?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, disease);
            pst.setInt(4, doctorId);
            pst.setDouble(5, bill);
            pst.setString(6, password);

            pst.executeUpdate();

            System.out.println("Patient Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}