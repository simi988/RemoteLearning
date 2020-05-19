package w15p6.Main;
import w15p6.DataBase.MyDB;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MyDB myDB = new MyDB();
        myDB.createDatabase();
        myDB.getInformation();
    }
}
