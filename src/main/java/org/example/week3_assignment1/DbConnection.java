package org.example.week3_assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/Week3ass1"; // Replace with your database URL
    private static final String USER = "root"; // Replace with your database username
    private static final String PASSWORD = "mariadb"; // Replace with your database password

    private Connection connection;

    public DbConnection() {
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void executeUpdate(String query, String value1, String value2, String value3) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set parameters for the prepared statement
            preparedStatement.setString(1, value1);
            preparedStatement.setString(2, value2);
            preparedStatement.setString(3, value3);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " rows affected.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}