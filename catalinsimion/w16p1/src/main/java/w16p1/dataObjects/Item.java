package w16p1.dataObjects;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;

@Table(name = "TBL_ITEM")
public class Item {
    @Column(name = "ITEM_NAME")
    String name;
    @Column(name = "ITEM_PRICE")
    double price;
    @Column(name = "ID", isPrimaryKey = true)
    int id;

    public int getId() {
        return id;
    }

    public Item(String name, double price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
}
