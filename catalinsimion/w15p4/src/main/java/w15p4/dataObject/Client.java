package w15p4.dataObject;

public class Client {
    private String UserName;
    private double balance;

    public Client(String UserName, double balance) {
        this.UserName = UserName;
        this.balance = balance;
    }

    public String getUserName() {
        return UserName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "UserName='" + UserName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
