package w15p4.dataObject;

public class Transaction {
    private Client client;
    private Double amount;
    private String description;

    public Transaction(Client client, Double amount) {
        this.client = client;
        this.amount = amount;
    }

    public Transaction(Client client, Double amount, String description) {
        this.client = client;
        this.amount = amount;
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

}
