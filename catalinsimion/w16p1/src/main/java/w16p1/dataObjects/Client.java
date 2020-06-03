package w16p1.dataObjects;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;

@Table(name = "TBL_CLIENT")
public class Client {
    @Column(name = "TABLE_NUMBER")
    int tableNumber;

    @Column(name = "MONEY")
    double budget;

    @Column(name = "ID",isPrimaryKey = true,autoIncrement = true)
    int id;

    public Client(int tableNumber, double budget,  int id) {
        this.tableNumber = tableNumber;
        this.budget = budget;
        this.id = id;
    }


    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public int getTableNumber() {
        return tableNumber;
    }
}
