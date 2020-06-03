package w16p1.operation;

import w16p1.dataObjects.Client;
import w16p1.dataObjects.Item;
import w16p1.dataObjects.Order;
import w16p1.dataObjects.Waiter;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class WaiterOperation {

    RestaurantOperation restaurantOption;

    public void addItem(Item item,Order order) {

        List<Item> itemList = order.getItemList();
        itemList.add(item);

    }

    public void removeItem(Item item,Order order) {

        List<Item> itemList = order.getItemList();
        itemList.remove(item);

    }

    public void getBill(Client client, Order order) {

        List<Item> itemList = order.getItemList();
        double totalPrice = 0;
        for (Item item : itemList) {
            double price = item.getPrice();
            totalPrice += price;
        }
    }

//    public void getFreeTable(Client client) {
//
//        int freeTable = restaurantOption.getFreeTable();
//        if (freeTable > 0) {
//            client.setTableNumber(freeTable);
//        } else {
//            err.println("Restaurant is full");
//        }
//    }

    public void serveOrder( Order order){

        out.println(order);

    }
public Order createOrder(Client client, Waiter waiter,int id){
    List<Item> itemList=new ArrayList<>();
        client.getTableNumber();
        return new Order(itemList,waiter,id,client);
}
}
