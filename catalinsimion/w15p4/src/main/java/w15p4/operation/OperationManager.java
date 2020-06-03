package w15p4.operation;


import w15p4.dataBase.MyDB;
import w15p4.dataObject.Transaction;

import java.sql.SQLException;

import static java.lang.System.*;

public class OperationManager {
    private final MyDB myDB;

    public OperationManager(MyDB myDB) {
        this.myDB = myDB;
    }

    public void payBill(Transaction transaction) throws SQLException {
        double newBalance = transaction.getClient().getBalance() - transaction.getAmount();

        if (newBalance >= 0) {
            transaction.getClient().setBalance(newBalance);
            myDB.updateClient(transaction.getClient());
            myDB.addTransaction(transaction);
        } else {
            err.println("The client " + transaction.getClient().getUserName() + " has insufficient money");
        }
    }

    public void receivedSalary(Transaction transaction) throws SQLException {
        double newBalance = transaction.getClient().getBalance() + transaction.getAmount();
        transaction.getClient().setBalance(newBalance);
        myDB.updateClient(transaction.getClient());
        myDB.addTransaction(transaction);
    }
}
