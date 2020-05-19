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

        PreparedStatement ps = connection.prepareStatement("select * from clients");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Table Name: " + rsmd.getTableName(1));
        System.out.println("Total columns: " + rsmd.getColumnCount());
        System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
        System.out.println("Column Name of 2st column: " + rsmd.getColumnName(2));
        System.out.println();
        PreparedStatement pas = connection.prepareStatement("select * from transactions");
        ResultSet rss = pas.executeQuery();
        ResultSetMetaData rssmd = rss.getMetaData();
        System.out.println("Table Name: " + rssmd.getTableName(1));
        System.out.println("Total columns: " + rssmd.getColumnCount());
        System.out.println("Column Name of 1st column: " + rssmd.getColumnName(1));
        System.out.println("Column Name of 2st column: " + rssmd.getColumnName(2));
        System.out.println("Column Name of 3st column: " + rssmd.getColumnName(3));
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