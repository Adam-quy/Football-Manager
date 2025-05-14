package org.example.demo.DAO;
import oracle.jdbc.OracleTypes;
import org.example.demo.models.Team;

import java.sql.*;

import org.example.demo.config.DatabaseConnection;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
public class DAO_CLB {

    public List<Team> getAllClubs() {
        List<Team> teams = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "SELECT TenCLB, LogoCLB FROM CLB";

        try {
            // Kết nối tới cơ sở dữ liệu
            DatabaseConnection db = DatabaseConnection.getInstance();
            conn = db.getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("TenCLB");
                String logoPath = rs.getString("LogoCLB");
//                System.out.println(name + " " + logoPath);
                Team team = new Team(name, logoPath);
                teams.add(team);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return teams;
    }
}
