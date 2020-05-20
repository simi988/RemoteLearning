package w15p4.dataBase;


import w15p4.dataObject.Client;
import w15p4.dataObject.Transaction;

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

    public void addClients(Client client) {
        String addClient = "INSERT INTO clients(username,balance) VALUES(?,?)";
        startConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addClient);
            preparedStatement.setString(1, client.getUserName());
            preparedStatement.setDouble(2, client.getBalance());
            try {
                preparedStatement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException throwable) {
                throwable.printStackTrace();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.err.println("Failed added: " + client.getUserName());
        } finally {
            closeConnection();
        }
    }

    public void addTransaction(Transaction transaction) {
        String addTransaction = "INSERT INTO transactions(client,amount, description) VALUES(?,?,?)";
        startConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addTransaction);
            preparedStatement.setString(1, transaction.getClient().getUserName());
            preparedStatement.setDouble(2, transaction.getAmount());
            preparedStatement.setString(3, transaction.getDescription());
            try {
                preparedStatement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException throwable) {
                throwable.printStackTrace();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.err.println("Failed added: " + transaction.getClient().getUserName());
        } finally {
            closeConnection();
        }
    }

    public void updateClientBalance(Client client) {
        String updateBalance = "UPDATE clients SET Balance=" + client.getBalance() + " WHERE UserName= '" + client.getUserName() + "';";
        startConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateBalance);

            try {
                preparedStatement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException throwable) {
                throwable.printStackTrace();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.err.println("Failed update: " + client.getUserName());
        } finally {
            closeConnection();
        }
    }

    public Client getClient(String name) {
        String query = "SELECT * from clients WHERE UserName= '" + name + "';";
        startConnection();
        Client client = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String clientName = resultSet.getString(1);
            double balance = resultSet.getDouble(2);
            client = new Client(clientName, balance);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection();
        }
        return client;
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