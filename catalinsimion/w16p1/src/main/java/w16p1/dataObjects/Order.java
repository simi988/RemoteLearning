package w16p1.dataObjects;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;

@Table(name = "TBL_ORDER")
public class Order {
    @Column(name = "ITEM")
    int item;
    @Column(name = "TABLE_NUMBER")
    int tableNumber;
    @Column(name = "ID", isPrimaryKey = true)
    int id;

    public Order(int item, int id, int tableNumber) {
        this.item = item;

        this.id = id;
        this.tableNumber = tableNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "item=" + item +
                '}';
    }
}
