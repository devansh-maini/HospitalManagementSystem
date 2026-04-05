package service;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LogService {

    public void logLogin(String userId, String role, String status) {

        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO login_log(user_id, role, status) VALUES(?,?,?)";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, userId);
            pst.setString(2, role);
            pst.setString(3, status);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logLogout(String userId, String role) {

        try {
            Connection conn = DBConnection.getConnection();

            String query = "UPDATE login_log SET logout_time = CURRENT_TIMESTAMP " +
                    "WHERE user_id=? AND role=? AND logout_time IS NULL " +
                    "ORDER BY login_time DESC LIMIT 1";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, userId);
            pst.setString(2, role);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}