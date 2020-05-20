package w15p4.main;

import w15p4.dataBase.MyDB;
import w15p4.dataObject.Client;
import w15p4.dataObject.Transaction;
import w15p4.operation.OperationManager;

public class Main {
    public static void main(String[] args) {
        MyDB myDB = new MyDB();
        Client client = myDB.getClient("Andrei");
        Transaction transaction = new Transaction(client, 90.00);
        Transaction transactionTwo = new Transaction(client, 1590.00);
        OperationManager operationManager = new OperationManager(myDB);
        myDB.createDatabase();
        myDB.addClients(client);
        operationManager.payBill(transaction);
        System.out.println(client);
        operationManager.receivedSalary(transactionTwo);
        System.out.println(client);
    }
}
