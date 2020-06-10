package w15p4.dataBase;


import w15p4.dataObject.Client;
import w15p4.dataObject.Transaction;

import java.sql.*;
import java.util.List;

import static java.lang.System.*;


public class MyDB {
    public static final String CREATE_DATABASE_IF_NOT_EXISTS_MYDATABASE = "CREATE DATABASE IF NOT EXISTS mydatabase";
    public static final String CREATE_TABLE_CLIENTS_QUERY = "CREATE TABLE IF NOT EXISTS CLIENTS " + "(UserName VARCHAR(255), " +
            " Balance Double,PRIMARY KEY (UserName))";
    public static final String CREATE_TABLE_TRANSACTION_QUERY = "CREATE TABLE IF NOT EXISTS TRANSACTIONS " + "(Client VARCHAR(255), " +
            " Amount Double,Description VARCHAR(255))";
    public static final String INSERT_INTO_CLIENTS_USERNAME_BALANCE_VALUES = "INSERT INTO CLIENTS(username,balance) VALUES(?,?)";
    public static final String INSERT_INTO_TRANSACTIONS_CLIENT_AMOUNT_DESCRIPTION_VALUES = "INSERT INTO TRANSACTIONS(client,amount, description) VALUES(?,?,?)";
    public static final String DROP_TABLE_CLIENTS = "DROP TABLE CLIENTS";
    public static final String DROP_TABLE_TRANSACTION = "DROP TABLE TRANSACTIONS";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    public static final String UPDATE_CLIENTS_SET_BALANCE_WHERE_USER_NAME = "UPDATE clients SET Balance=? WHERE UserName=?";
    Connection connection = null;

    public void createDatabase() {

        Statement stmt;
        startConnection();
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(CREATE_DATABASE_IF_NOT_EXISTS_MYDATABASE);
            stmt.executeUpdate(CREATE_TABLE_CLIENTS_QUERY);
            stmt.executeUpdate(CREATE_TABLE_TRANSACTION_QUERY);
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    public void addClient(Client client) throws SQLException {
        PreparedStatement preparedStatement = createPreparedStatement(INSERT_INTO_CLIENTS_USERNAME_BALANCE_VALUES);
        preparedStatement.setString(1, client.getUserName());
        preparedStatement.setDouble(2, client.getBalance());
        executeUpdate(preparedStatement);
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        PreparedStatement preparedStatement = createPreparedStatement(INSERT_INTO_TRANSACTIONS_CLIENT_AMOUNT_DESCRIPTION_VALUES);
        preparedStatement.setString(1, transaction.getClient().getUserName());
        preparedStatement.setDouble(2, transaction.getAmount());
        preparedStatement.setString(3, transaction.getDescription());
        executeUpdate(preparedStatement);

    }

    public void updateClient(Client client) throws SQLException {
        PreparedStatement preparedStatement = createPreparedStatement(UPDATE_CLIENTS_SET_BALANCE_WHERE_USER_NAME);
        preparedStatement.setDouble(1, client.getBalance());
        preparedStatement.setString(2, client.getUserName());
        executeUpdate(preparedStatement);
    }

    public void dropTable() {
        try {
            PreparedStatement preparedStatementClient = connection.prepareStatement(DROP_TABLE_CLIENTS);
            PreparedStatement preparedStatementTransaction = connection.prepareStatement(DROP_TABLE_TRANSACTION);
            executeUpdate(preparedStatementClient);
            executeUpdate(preparedStatementTransaction);
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    public void addWithBatch(List<Client> clients) throws SQLException {
        try {
            PreparedStatement preparedStatement = createPreparedStatement(INSERT_INTO_CLIENTS_USERNAME_BALANCE_VALUES);

            connection.setAutoCommit(false);
            for (Client client:clients) {
                preparedStatement.setString(1, client.getUserName());
                preparedStatement.setDouble(2, client.getBalance());
                preparedStatement.addBatch();
            }
            int[] result = preparedStatement.executeBatch();
            out.println("The number of rows inserted: " + result.length);
            connection.commit();
        } catch (Exception exception) {
            err.println(exception.getMessage());
            connection.rollback();
        }
    }

    private void startConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }


    private void executeUpdate(PreparedStatement preparedStatement) throws SQLException {
        Savepoint savePoint = connection.setSavepoint();
        try {
            connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException exception) {
            err.println(exception.getMessage());
            connection.rollback(savePoint);
        }

    }

    private PreparedStatement createPreparedStatement(String query) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }

        return preparedStatement;
    }


}
