package w16p1.dataBase;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;

import java.lang.reflect.Field;
import java.sql.*;

import static java.lang.System.err;
import static java.lang.System.out;

public class DAO<T> {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String CREATE_DATABASE_IF_NOT_EXISTS_MYDATABASE = "CREATE DATABASE IF NOT EXISTS mydatabase";
    private static final String CREATE_TABLE_CLIENT = "CREATE TABLE IF NOT EXISTS TBL_CLIENT " + "(TABLE_NUMBER INTEGER, " +
            " MONEY Double,ID LONG)";
    private static final String CREATE_TABLE_ITEM = "CREATE TABLE IF NOT EXISTS TBL_ITEM " + "(ITEM_NAME VARCHAR(255), " +
            " ITEM_PRICE Double,ID LONG)";
    private static final String CREATE_TABLE_ORDER = "CREATE TABLE IF NOT EXISTS TBL_ORDER " + "(WAITER VARCHAR(255), " +
            " ID LONG,TABLE_NUMBER INTEGER)";
    private static final String CREATE_TABLE_WAITER = "CREATE TABLE IF NOT EXISTS TBL_WAITER " + "(NAME VARCHAR(255), " +
            " PRICE Double,ID LONG)";
    private static final String CREATE_TABLE_RESTAURANT = "CREATE TABLE IF NOT EXISTS TBL_RESTAURANT " + "(WAITER VARCHAR(255), " +
            " TABLE_NUMBER INTEGER,ID LONG)";
    private static final String DROP_TABLE_TBL_CLIENT = "DROP TABLE TBL_CLIENT";
    private static final String DROP_TABLE_TBL_ITEM = "DROP TABLE TBL_ITEM";
    private static final String DROP_TABLE_TBL_ORDER = "DROP TABLE TBL_ORDER";
    private static final String DROP_TABLE_TBL_WAITER = "DROP TABLE TBL_WAITER";
    private static final String DROP_TABLE_TBL_RESTAURANT = "DROP TABLE TBL_RESTAURANT";

    Connection connection = null;

    public void createDatabase() {
        Statement stmt;
        startConnection();
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(CREATE_DATABASE_IF_NOT_EXISTS_MYDATABASE);
            stmt.executeUpdate(CREATE_TABLE_CLIENT);
            stmt.executeUpdate(CREATE_TABLE_ITEM);
            stmt.executeUpdate(CREATE_TABLE_ORDER);
            stmt.executeUpdate(CREATE_TABLE_WAITER);
            stmt.executeUpdate(CREATE_TABLE_RESTAURANT);
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    public void insert(T myClass) throws IllegalAccessException {
        Table tableName = myClass.getClass().getAnnotation(Table.class);
        String insert = "INSERT INTO " + tableName.name() + " VALUES(";
        Field[] declaredFields = myClass.getClass().getDeclaredFields();
        String insertField = getInsertField(myClass, insert, declaredFields);
        PreparedStatement preparedStatement = createPreparedStatement(insertField);
        executeUpdate(preparedStatement);
    }

    public void select(T myClass) throws IllegalAccessException {
        Table tableName = myClass.getClass().getAnnotation(Table.class);
        Field[] declaredFields = myClass.getClass().getDeclaredFields();
        String select = "SELECT * FROM " + tableName.name() + " WHERE ";
        String query = getSelectField(myClass, declaredFields, select);
        PreparedStatement preparedStatement = createPreparedStatement(query);
        executeQuery(preparedStatement);
    }

    public void delete(T myClass) throws IllegalAccessException {
        Table tableName = myClass.getClass().getAnnotation(Table.class);
        Field[] declaredFields = myClass.getClass().getDeclaredFields();
        String delete = "DELETE FROM " + tableName.name() + " WHERE ";
        String query = getSelectField(myClass, declaredFields, delete);
        PreparedStatement preparedStatement = createPreparedStatement(query);
        executeUpdate(preparedStatement);
    }

    public void update(T myClass) throws IllegalAccessException {
        Table tableName = myClass.getClass().getAnnotation(Table.class);
        Field[] declaredFields = myClass.getClass().getDeclaredFields();
        String update = "UPDATE " + tableName.name() + " SET ";
        update = getUpdateField(myClass, declaredFields, update);
        PreparedStatement preparedStatement = createPreparedStatement(update);
        executeUpdate(preparedStatement);
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    public void dropTable() {
        try {
            PreparedStatement preparedStatementClient = connection.prepareStatement(DROP_TABLE_TBL_CLIENT);
            executeUpdate(preparedStatementClient);
            PreparedStatement preparedStatementItem = connection.prepareStatement(DROP_TABLE_TBL_ITEM);
            executeUpdate(preparedStatementItem);
            PreparedStatement preparedStatementOrder = connection.prepareStatement(DROP_TABLE_TBL_ORDER);
            executeUpdate(preparedStatementOrder);
            PreparedStatement preparedStatementWaiter = connection.prepareStatement(DROP_TABLE_TBL_WAITER);
            executeUpdate(preparedStatementWaiter);
            PreparedStatement preparedStatementRestaurant = connection.prepareStatement(DROP_TABLE_TBL_RESTAURANT);
            executeUpdate(preparedStatementRestaurant);
        } catch (SQLException exception) {
            out.println(exception.getMessage());
        }
    }

    private void startConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    private String getInsertField(T myClass, String insert, Field[] declaredFields) throws IllegalAccessException {
        int count = 1;
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object value = field.get(myClass);
            insert += "'" + value.toString();
            if (declaredFields.length > count) {
                insert += "',";
            }
            count++;
        }
        insert += "')";
        return insert;
    }

    private String getSelectField(T myClass, Field[] declaredFields, String select) throws IllegalAccessException {
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Column columnName = field.getAnnotation(Column.class);
            Object value = field.get(myClass);
            if (columnName.isPrimaryKey()) {
                select += columnName.name() + "= " + value;
            }
        }
        return select;
    }

    private String getUpdateField(T myClass, Field[] declaredFields, String update) throws IllegalAccessException {
        int count = 2;
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Column columnName = field.getAnnotation(Column.class);
            Object value = field.get(myClass);
            if (!columnName.isPrimaryKey()) {
                update += columnName.name() + "='" + value + "'";
            } else {
                update += " WHERE " + columnName.name() + "=" + value;
            }
            if (declaredFields.length > count) {
                update += ",";
            }

            count++;
        }
        return update;
    }

    private void executeUpdate(PreparedStatement preparedStatement) {
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    private void executeQuery(PreparedStatement preparedStatement) {
        try {
            preparedStatement.executeQuery();
        } catch (SQLException exception) {
            out.println(exception.getMessage());
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
