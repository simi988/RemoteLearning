package w15p4.Operation;

import w15p4.DataObject.Transaction;
import w15p4.Database.MyDB;

public class OperationManager {
  private MyDB myDB;

    public OperationManager(MyDB myDB) {
        this.myDB = myDB;
    }

    public void payBill(Transaction transaction){
        double newBalance = transaction.getClient().getBalance() - transaction.getAmount();

        if (newBalance>=0){
            transaction.getClient().setBalance(newBalance);
            myDB.updateClientBalance(transaction.getClient());
            myDB.addTransaction(transaction);
        }
        else{
            System.err.println("The client "+transaction.getClient().getUserName()+ " has insufficient money");
        }
    }
    public void receivedSalary(Transaction transaction){
        double newBalance = transaction.getClient().getBalance() + transaction.getAmount();
        transaction.getClient().setBalance(newBalance);
        myDB.updateClientBalance(transaction.getClient());
        myDB.addTransaction(transaction);
    }
}
