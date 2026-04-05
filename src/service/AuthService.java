package service;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthService {

    LogService logService = new LogService();

    // ================= ADMIN LOGIN =================

    public boolean adminLogin(String username, String password) {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM admin WHERE username=? AND password=?";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                logService.logLogin(username, "ADMIN", "SUCCESS");
                return true;
            } else {
                logService.logLogin(username, "ADMIN", "FAILED");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    // ================= PATIENT LOGIN =================

    public boolean patientLogin(int id, String password) {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM patient WHERE patient_id=? AND password=?";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                logService.logLogin(String.valueOf(id), "PATIENT", "SUCCESS");
                return true;
            } else {
                logService.logLogin(String.valueOf(id), "PATIENT", "FAILED");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    // ================= DOCTOR LOGIN =================

    public boolean doctorLogin(int id, String password) {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM doctor WHERE doctor_id=? AND password=?";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                logService.logLogin(String.valueOf(id), "DOCTOR", "SUCCESS");
                return true;
            } else {
                logService.logLogin(String.valueOf(id), "DOCTOR", "FAILED");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    // ================= LOGOUT METHODS =================

    public void adminLogout(String username) {
        logService.logLogout(username, "ADMIN");
    }

    public void patientLogout(int id) {
        logService.logLogout(String.valueOf(id), "PATIENT");
    }

    public void doctorLogout(int id) {
        logService.logLogout(String.valueOf(id), "DOCTOR");
    }

}