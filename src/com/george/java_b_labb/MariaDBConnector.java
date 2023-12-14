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
    public void writeToPlayer(String name, int strength, int intelligence, int agility, int health, int experience, int level, int baseDamage, int gold)
    {
        try {
            open();
            String insertDataQuery = "INSERT INTO players (name, strength, intelligence, agility, health, experience, level, baseDamage, gold) VALUES (?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(insertDataQuery)) {
                statement.setString(1, name);
                statement.setInt(2,strength);
                statement.setInt(3,intelligence);
                statement.setInt(4,agility);
                statement.setInt(5,health);
                statement.setInt(6, experience);
                statement.setInt(7,level);
                statement.setInt(8,baseDamage);
                statement.setInt(9, gold);
                statement.executeUpdate();
                System.out.println("Data has been successfully written to the database.");
            }
        } catch (SQLException e) {
            System.out.println("Error writing to the database: " + e.getMessage());
        }
    }

    public void writeToPlayer (String status) {
    }
}







/*package com.george.java_b_labb;

import java.sql.*;

public class MariaDBConnector {
    private String URL = "jdbc:mariadb://localhost:3306/java_b_labb";
    private String USER = "root";
    private String password = "Bosco4Ever79";
    private Connection connection;

    // Method to open a database connection
    public void open () {
        try {
            connection = DriverManager.getConnection(URL, USER, password);
            System.out.println("Database connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Get the database connection object
    public Connection getConnection () {
        return connection;
    }

    // Write data to both the database and a file
    public void writeToPlayer(String data) {
        int incrementID = -1; // Initialize with a default value

        try {
            open();
            String insertDataQuery = "INSERT INTO players (name, strength, intelligence, agility, health, experience, level, baseDamage, gold) VALUES (?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement statement = connection.prepareStatement(insertDataQuery, Statement.RETURN_GENERATED_KEYS)) {
                String[] values = data.split(",");

                if (values.length == 9) {
                    for (int i = 0; i < 9; i++) {
                        statement.setString(i + 1, values[i]);
                    }

                    statement.executeUpdate();

                    // Retrieve the auto-generated keys
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        while (generatedKeys.next()) {
                            incrementID = generatedKeys.getInt(1);
                        }
                    }

                    connection.commit();
                    System.out.println("Data has been successfully written to the database. Generated ID: " + incrementID);
                } else {
                    System.out.println("Error: Number of values in data does not match the number of placeholders in the SQL query.");
                    System.out.println("Data string: " + data);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error writing to the database: " + e.getMessage());
        }
    }
}




   /* public void writeToPlayer() {
        try {
            open();
            String insertDataQuery = "INSERT INTO monster (data) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(insertDataQuery)) {
                statement.setString(1, data);
                statement.executeUpdate();
                statement.close();
                connection.commit();
                System.out.println("Data has been successfully written to the database.");
            }
        } catch (SQLException e) {
            System.out.println("Error writing to the database: " + e.getMessage());
        }*/
