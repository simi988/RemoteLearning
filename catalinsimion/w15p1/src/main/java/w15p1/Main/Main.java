package w15p1.Main;

import w15p1.Client.Client;
import w15p1.DataBase.MyDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        MyDB myDB = new MyDB();
        myDB.createDatabase();
        Client client = new Client("Andrei", 121.00);
        Client client1 = new Client("Denisa", 1211.00);
        Client client2 = new Client("Mihai", 1587571211.00);
        Client client3 = new Client("Gigi", 1617757645.00);
        Client client4 = new Client("Catalin", 121111.00);
        Client client5 = new Client("Guta", 12);
        myDB.addClient(client5);
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        clientList.add(client4);
        myDB.addClients(clientList);
        myDB.getAllClients().forEach(clients -> out.println("UserName: " + clients.getUserName() +
                ", Balance: " + clients.getBalance()));
        out.println();
        out.println(myDB.getBalance(client2));
        out.println();
        myDB.getRichClients(10000).forEach(clients -> out.println("UserName: " + clients.getUserName() +
                ", Balance: " + clients.getBalance()));
        myDB.dropTable();
        myDB.closeConnection();
    }
}
