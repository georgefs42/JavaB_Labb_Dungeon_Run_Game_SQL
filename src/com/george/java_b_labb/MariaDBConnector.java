package com.george.java_b_labb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MariaDBConnector {
    private String URL = "jdbc:mariadb://localhost:3306/java_b_labb";
    private String USER = "root";
    private String password = "xxxxxx";
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
