package w16p1.main;

import w16p1.dataBase.MyDB;
import w16p1.dataObjects.*;
import w16p1.operation.RestaurantOperation;
import w16p1.operation.WaiterOperation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        MyDB myDB = new MyDB();
        myDB.createDatabase();

        List<Order> orderList = new ArrayList<>();
        List<Waiter> waiterList = new ArrayList<>();
        Waiter waiter = new Waiter("Alex", 1200, orderList, 1);

        Restaurant restaurant = new Restaurant(waiterList, 10, 1);
        RestaurantOperation restaurantOperation = new RestaurantOperation(restaurant);
        Client client = restaurantOperation.newClient(120, 1);
        WaiterOperation waiterOperation = new WaiterOperation();
        Order order = waiterOperation.createOrder(client, waiter, 1);
      //  myDB.insert();


    }
}
