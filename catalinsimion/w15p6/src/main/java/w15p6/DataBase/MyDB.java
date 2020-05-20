package w15p6.DataBase;

import java.sql.*;

public class MyDB {
    String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    String USERNAME = "root";
    String PASSWORD = "password";
    Connection connection = null;

    public void createDatabase() {
        String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS mydatabase";
        String createTableClientsQuery = "CREATE TABLE IF NOT EXISTS clients " + "(UserName VARCHAR(255), " +
                " Balance Double,PRIMARY KEY (UserName))";
        String createTableTransactionQuery = "CREATE TABLE IF NOT EXISTS transactions " + "(Client VARCHAR(255), " +
                " Amount Double,Description VARCHAR(255))";
        Statement stmt = null;
        startConnection();
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(createDatabaseQuery);
            stmt.executeUpdate(createTableClientsQuery);
            stmt.executeUpdate(createTableTransactionQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void getInformation() throws SQLException {
        startConnection();

        PreparedStatement prepareStatementClient = connection.prepareStatement("select * from clients");
        ResultSet resultSetClient = prepareStatementClient.executeQuery();
        ResultSetMetaData resultSetClientMetaData = resultSetClient.getMetaData();
        System.out.println("Table Name: " + resultSetClientMetaData.getTableName(1));
        System.out.println("Total columns: " + resultSetClientMetaData.getColumnCount());
        System.out.println("Column Name of 1st column: " + resultSetClientMetaData.getColumnName(1));
        System.out.println("Column Name of 2st column: " + resultSetClientMetaData.getColumnName(2));
        System.out.println();
        PreparedStatement prepareStatementTransaction = connection.prepareStatement("select * from transactions");
        ResultSet resultSetTransaction = prepareStatementTransaction.executeQuery();
        ResultSetMetaData resultSetTransactionMetaData = resultSetTransaction.getMetaData();
        System.out.println("Table Name: " + resultSetTransactionMetaData.getTableName(1));
        System.out.println("Total columns: " + resultSetTransactionMetaData.getColumnCount());
        System.out.println("Column Name of 1st column: " + resultSetTransactionMetaData.getColumnName(1));
        System.out.println("Column Name of 2st column: " + resultSetTransactionMetaData.getColumnName(2));
        System.out.println("Column Name of 3st column: " + resultSetTransactionMetaData.getColumnName(3));
        closeConnection();
    }

    private void startConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}