package w15p4.DataObject;

import w15p4.DataObject.Client;

public class Transaction {
  private Client client;
  private  Double amount;
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

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
