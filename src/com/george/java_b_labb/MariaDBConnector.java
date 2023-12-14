package com.george.java_b_labb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MariaDBConnector {
    private String URL = "jdbc:mariadb://localhost:3306/java_b_labb";
    private String USER = "root";
    private String password = "Bosco4Ever79";
    private Connection connection;

    // Method to open a database connection
    public void open() {
        try {
            connection = DriverManager.getConnection(URL, USER, password);
            System.out.println("Database connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Get the database connection object
    public Connection getConnection() {
        return connection;
    }

    // Write data to both the database and a file
    public void writeToFile(String data) {
        try {
            open();
            String insertDataQuery = "INSERT INTO output_data (data) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(insertDataQuery)) {
                statement.setString(1, data);
                statement.executeUpdate();
                System.out.println("Data has been successfully written to the database.");
            }
        } catch (SQLException e) {
            System.out.println("Error writing to the database: " + e.getMessage());
        }
    }
}
