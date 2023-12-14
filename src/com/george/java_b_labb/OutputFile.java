package com.george.java_b_labb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OutputFile {
    private String fileName;
    private MariaDBConnector dbConnector;

    // Constructor with initialization of the database
    public OutputFile(String fileName, MariaDBConnector dbConnector) {
        this.fileName = fileName;
        this.dbConnector = dbConnector;
        initializeDatabase();
    }

    // Initialize the database table if it doesn't exist
    private void initializeDatabase() {
        try {
            dbConnector.open();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS output_data (id INT AUTO_INCREMENT PRIMARY KEY, data TEXT)";
            try (PreparedStatement statement = dbConnector.getConnection().prepareStatement(createTableQuery)) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }

    // Get and store the status data
    public void getStatus(String status) {
        writeToFile(status);
    }

    // Write status data to both the database and a file
    private void writeToFile(String data) {
        dbConnector.writeToFile(data);
        // Write to the file (your existing file writing logic)
    }
}
