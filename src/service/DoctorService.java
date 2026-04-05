package service;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DoctorService {

    public void addDoctor() {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Doctor Name: ");
            String name = sc.nextLine();

            System.out.print("Specialization: ");
            String specialization = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO doctor(name,specialization,password) VALUES(?,?,?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, name);
            pst.setString(2, specialization);
            pst.setString(3, password);

            pst.executeUpdate();

            System.out.println("Doctor Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}