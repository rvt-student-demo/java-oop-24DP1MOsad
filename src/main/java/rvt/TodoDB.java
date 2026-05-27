package rvt;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoDB {
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public TodoDB() {
        initSchema();
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchema() {
        String sql = "CREATE TABLE IF NOT EXISTS todo (id INTEGER PRIMARY KEY, task TEXT NOT NULL) STRICT";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }

    public void add(String task) {
        String sql = "INSERT INTO todo(task) VALUES(?)";
        try (
                Connection conn = connect();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, task);
            ps.executeUpdate();
            System.out.println("Task added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> findAll() {
        ArrayList<String[]> arr = new ArrayList<>();

        String sql = "SELECT id, task FROM todo ORDER BY id";
        try (
                Connection conn = connect();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String[] row = { id, rs.getString("task") };
                arr.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arr;
    }

    public void removeById(int id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        try (
                Connection conn = connect();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
