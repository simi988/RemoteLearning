package w15p1.Main;

import w15p1.Client.Client;
import w15p1.DataBase.MyDB;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        MyDB myDB = new MyDB();
        myDB.createDatabase();
        Client client = new Client("Andrei", 121.00);
        Client client1 = new Client("Denisa", 1211.00);
        Client client2 = new Client("Mihai", 1587571211.00);
        Client client3 = new Client("Gigi", 1617757645.00);
        Client client4 = new Client("Catalin", 121111.00);

        myDB.addClients(client);
        myDB.addClients(client1);
        myDB.addClients(client2);
        myDB.addClients(client3);
        myDB.addClients(client4);
        myDB.getAllClients().forEach(clients -> System.out.println("UserName: " + clients.getUserName() +
                ", Balance: " + clients.getBalance()));
        System.out.println();
        System.out.println(myDB.getBalance(client2));
        System.out.println();
        myDB.getRichClients().forEach(clients -> System.out.println("UserName: " + clients.getUserName() +
                ", Balance: " + clients.getBalance()));
    }
}
