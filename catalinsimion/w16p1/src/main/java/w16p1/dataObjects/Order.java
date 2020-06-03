package w16p1.dataObjects;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;

import java.util.List;

@Table(name = "TBL_ORDER")
public class Order {
    @Column(name = "ITEM_ORDER_LIST")
    List<Item> itemList;
    @Column(name="WAITER_ON_THE_ORDER")
    Waiter waiter;
    @Column(name = "ID",isPrimaryKey = true)
    int id;
    @Column(name="CLIENT_ORDDER")
    Client client;

    public Order(List<Item> itemList, Waiter waiter, int id, Client client) {
        this.itemList = itemList;
        this.waiter = waiter;
        this.id = id;
        this.client = client;
    }

    public List<Item> getItemList() {
        return itemList;
    }


    @Override
    public String toString() {
        return "Order{" +
                "itemList=" + itemList +
                ", waiter=" + waiter +
                '}';
    }
}
