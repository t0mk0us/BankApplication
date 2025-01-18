package com.tamara.bankappli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;"
                + "database=Bank;"
                + "user=sa;"
                + "password=K1ev2oo1;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
                Statement statement = connection.createStatement(); {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from CUSTOMER";
           // System.out.print(selectSql);
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5));
            	}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}