package w16p1.service;

import w16p1.dataBase.DAO;
import w16p1.dataObjects.Client;
import w16p1.dataObjects.Item;
import w16p1.dataObjects.Order;
import w16p1.dataObjects.Waiter;

import static java.lang.System.out;

public class WaiterService {
    DAO dao;

    public WaiterService(DAO dao) {
        this.dao = dao;
    }

    public void takeCommand(Item item, Waiter waiter, Client client) throws IllegalAccessException {
        dao.insert(item);
        out.println("The tables " + client.getTableNumber() + " wants " + item.getName());
        processOrder(item, waiter, client);
    }

    public void processOrder(Item item, Waiter waiter, Client client) throws IllegalAccessException {
        dao.select(item);
        out.println("Waiter " + waiter.getName() + " served the command " + item.getName() + " to table " + client.getTableNumber());
    }

    public void removeItem(Item item) throws IllegalAccessException {
        dao.delete(item);
    }

    public void getBill(Item item) {
        out.println("The bill is: " + item.getPrice());
    }

    public Order createOrder(Client client, Item item, int id) {
        return new Order(item.getId(), id, client.getTableNumber());
    }
}
