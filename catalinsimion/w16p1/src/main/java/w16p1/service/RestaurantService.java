package w16p1.service;

import w16p1.dataBase.DAO;
import w16p1.dataObjects.*;

import static java.lang.System.*;

public class RestaurantService {
    DAO dao;
    Restaurant restaurant;

    public RestaurantService(Restaurant restaurant, DAO dao) {
        this.restaurant = restaurant;
        this.dao = dao;
    }

    public void dismissWaiter(Waiter waiter) throws IllegalAccessException {
        dao.delete(waiter);
        out.println(waiter.getName() + " is fired");
    }

    public Waiter engageWaiter(String name, double salary, Order order, int id) {
        out.println(name + " is your new waiter");
        return new Waiter(name, salary, order, id);
    }

    public void putMoreTables(int number) {
        int newNumberOfTables = restaurant.getNumberOfTables() + number;
        restaurant.setNumberOfTables(newNumberOfTables);
        out.println("After adding table in restaurant is " + newNumberOfTables + " table");
    }

    public void removeTables(int number) {
        int numberOfTables = restaurant.getNumberOfTables();
        int newNumberOfTables = numberOfTables - number;
        if (newNumberOfTables >= 0) {
            restaurant.setNumberOfTables(newNumberOfTables);
            out.println("After removing table in restaurant is " + newNumberOfTables + " table");
        } else {
            err.println("Invalid number of tables");
        }
    }

    public void changeItemPrice(Item item, double price) throws IllegalAccessException {
        item.setPrice(price);
        dao.update(item);
        System.out.println("New price at " + item.getName() + " is " + price);
    }

    public int getFreeTable() {
        int numberOfTables = restaurant.getNumberOfTables();
        int table = 0;
        if (numberOfTables > 0) {
            table = numberOfTables;
            numberOfTables--;
        } else {
            err.println("Restaurant is full");
        }
        return table;
    }

    public Client newClient(double budget, int id) {
        int freeTable = getFreeTable();
        return new Client(freeTable, budget, id);
    }
}