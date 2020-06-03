package w15p1.DataBase;

import w15p1.Client.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class MyDB {
    public static final String DROP_TABLE_CLIENTS = "DROP TABLE CLIENTS";
    public static final String INSERT_INTO_CLIENTS_USERNAME_BALANCE_VALUES = "INSERT INTO CLIENTS(username,balance) VALUES(?,?)";
    public static final String SELECT_USER_NAME_FROM_CLIENTS_WHERE_USER_NAME = "SELECT Balance from clients where UserName=?";
    public static final String SELECT_FROM_CLIENTS_WHERE_BALANCE = "SELECT * from CLIENTS where Balance>?";
    public static final String SELECT_FROM_CLIENTS = "SELECT * from CLIENTS";
    public static final String CREATE_DATABASE_IF_NOT_EXISTS_MYDATABASE = "CREATE DATABASE IF NOT EXISTS MYDATABASE";
    public static final String CREATE_TABLE_CLIENTS_QUERY = "CREATE TABLE IF NOT EXISTS CLIENTS " + "(UserName VARCHAR(255), " +
            " Balance Double,PRIMARY KEY (UserName))";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    Connection connection = null;

    public void createDatabase() {
        Statement stmt;
        startConnection();
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(CREATE_DATABASE_IF_NOT_EXISTS_MYDATABASE);
            stmt.executeUpdate(CREATE_TABLE_CLIENTS_QUERY);
        } catch (SQLException exception) {
            out.println(exception.getMessage());
        }
    }

    public void addClient(Client client) throws SQLException {
        PreparedStatement preparedStatement = createPreparedStatement(INSERT_INTO_CLIENTS_USERNAME_BALANCE_VALUES);
        preparedStatement.setString(1, client.getUserName());
        preparedStatement.setDouble(2, client.getBalance());
        executeUpdate(preparedStatement);
    }

    public List<Client> getAllClients() throws SQLException {
        PreparedStatement preparedStatement = createPreparedStatement(SELECT_FROM_CLIENTS);
        ResultSet resultSet = executeQuery(preparedStatement);
        return createClients(resultSet);
    }

    public List<Client> getRichClients(double balance) throws SQLException {
        PreparedStatement preparedStatement = createPreparedStatement(SELECT_FROM_CLIENTS_WHERE_BALANCE);
        preparedStatement.setDouble(1, balance);
        ResultSet resultSet = executeQuery(preparedStatement);
        return createClients(resultSet);
    }

    public double getBalance(Client client) throws SQLException {
        PreparedStatement preparedStatement = createPreparedStatement(SELECT_USER_NAME_FROM_CLIENTS_WHERE_USER_NAME);
        preparedStatement.setString(1, client.getUserName());
        ResultSet resultSet = executeQuery(preparedStatement);
        resultSet.next();
        return resultSet.getDouble(1);
    }

    public void dropTable() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_CLIENTS);
            executeUpdate(preparedStatement);
        } catch (SQLException exception) {
            out.println(exception.getMessage());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    public void addClients(List<Client> clients) throws SQLException {
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
        }catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    private ResultSet executeQuery(PreparedStatement preparedStatement) {
        ResultSet resultSet = null;
        try {
            connection.setAutoCommit(false);
            resultSet = preparedStatement.executeQuery();
            connection.commit();
        } catch (SQLException exception) {
            out.println(exception.getMessage());
        }
        return resultSet;
    }

    private void executeUpdate(PreparedStatement preparedStatement) {
        try {
            connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException exception) {
            out.println(exception.getMessage());
        }
    }

    private List<Client> createClients(ResultSet resultSet) throws SQLException {
        List<Client> clientList = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            double balance1 = resultSet.getDouble(2);
            clientList.add(new Client(name, balance1));
        }
        return clientList;
    }

    private PreparedStatement createPreparedStatement(String query) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException exception) {
            out.println(exception.getMessage());

        }
        return preparedStatement;
    }
}
