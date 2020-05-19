package w15p4.Main;

import w15p4.DataObject.Client;
import w15p4.DataObject.Transaction;
import w15p4.Database.MyDB;
import w15p4.Operation.OperationManager;

public class Main {
    public static void main(String[] args) {
        MyDB myDB=new MyDB();
        Client client=myDB.getClient("Andrei");
        Transaction transaction=new Transaction(client,90.00);
        OperationManager operationManager=new OperationManager(myDB);
        myDB.createDatabase();
        myDB.addClients(client);
        operationManager.payBill(transaction);
        System.out.println(client);

    }
}
