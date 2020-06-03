package w16p1.dataBase;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;
import w16p1.dataObjects.Client;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.err;

public class MyDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    public static final String CREATE_DATABASE_IF_NOT_EXISTS_MYDATABASE = "CREATE DATABASE IF NOT EXISTS mydatabase";

    Connection connection = null;

    public void createDatabase() {

        Statement stmt;
        startConnection();
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(CREATE_DATABASE_IF_NOT_EXISTS_MYDATABASE);

        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    public void insert(Class<?> myClass) {

        Table tableName=  myClass.getAnnotation(Table.class);
        String insert="INSERT INTO"+tableName.name();
        Field[] declaredFields = myClass.getDeclaredFields();
        for (Field field:declaredFields) {
            Column columnName = field.getAnnotation(Column.class);
            insert += (" VALUES(" + columnName + ")");
        }
    }


    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }

    private void startConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException exception) {
            err.println(exception.getMessage());
        }
    }
}
