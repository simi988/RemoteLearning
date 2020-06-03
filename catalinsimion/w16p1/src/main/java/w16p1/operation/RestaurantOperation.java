package w16p1.operation;

import w16p1.dataObjects.Client;
import w16p1.dataObjects.Order;
import w16p1.dataObjects.Restaurant;
import w16p1.dataObjects.Waiter;

import java.util.List;

import static java.lang.System.*;

public class RestaurantOperation {

    Restaurant restaurant;

    public RestaurantOperation(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void dismissWaiter(Waiter waiter) {
        List<Waiter> waiterList = restaurant.getWaiterList();
        waiterList.remove(waiter);
    }

    public void engageWaiter(Waiter waiter) {
        List<Waiter> waiterList = restaurant.getWaiterList();
        waiterList.add(waiter);
    }

    public void putMoreTables(int number) {
        restaurant.setNumberOfTables(number);
    }

    public void removeTables(int number) {
        int numberOfTables = restaurant.getNumberOfTables();
        int newNumberOfTables = numberOfTables - number;
        if (newNumberOfTables >= 0) {
            restaurant.setNumberOfTables(newNumberOfTables);
        } else {
            err.println("Invalid number of tables");
        }
    }
    public int getFreeTable(){
        int numberOfTables = restaurant.getNumberOfTables();
        int table = 0;
        if (numberOfTables > 0) {
         table=numberOfTables;
        numberOfTables--;
        } else {
            err.println("Restaurant is full");
        }
        return table;
    }
    public Client newClient(double budget,int id){
        int freeTable = getFreeTable();
        return new Client(freeTable,budget,id);
    }
}
