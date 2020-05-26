package w15p1.DataBase;

import w15p1.Client.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDB {
    String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    String USERNAME = "root";
    String PASSWORD = "password";
    Connection connection = null;

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

    public void createDatabase() {
        String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS MYDATABASE";
        String createTableClientsQuery = "CREATE TABLE IF NOT EXISTS CLIENTS " + "(UserName VARCHAR(255), " +
                " Balance Double,PRIMARY KEY (UserName))";
        Statement stmt = null;
        startConnection();
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(createDatabaseQuery);
            stmt.executeUpdate(createTableClientsQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void addClients(Client client) throws SQLException {
        connection.setAutoCommit(false);
        String add = "INSERT INTO CLIENTS(username,balance) VALUES(?,?)";
        startConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setString(1, client.getUserName());
            preparedStatement.setDouble(2, client.getBalance());
            try {
                preparedStatement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException throwable) {
                throwable.printStackTrace();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public List<Client> getAllClients() throws SQLException {
        connection.setAutoCommit(false);
        List<Client> clientList = new ArrayList<>();
        String queryOne = "SELECT * from CLIENTS ";
        startConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryOne);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                double balance = resultSet.getDouble(2);
                clientList.add(new Client(name, balance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return clientList;
    }

    public double getBalance(Client client) throws SQLException {
        connection.setAutoCommit(false);
        String queryTwo = "SELECT UserName from clients where UserName='client.getUserName()' ";
        double balance = 0;
        startConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryTwo);
            preparedStatement.executeQuery();
            balance = client.getBalance();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return balance;
    }

    public List<Client> getRichClients() throws SQLException {
        connection.setAutoCommit(false);
        List<Client> clientRichList = new ArrayList<>();
        String queryThree = "SELECT * from CLIENTS where Balance> 100000;";
        startConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryThree);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                double balance = resultSet.getDouble(2);
                clientRichList.add(new Client(name, balance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return clientRichList;
    }

    public void dropTable() throws SQLException {
        String drop = "DROP TABLE CLIENTS";
        startConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(drop);
            preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
