package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.NonRegisteringDriver;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "!789qwe!";
    private Connection connection;

    public Util() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Connection is successful");
            }
        } catch (SQLException ex) {
            System.err.println("Driver is lost");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
