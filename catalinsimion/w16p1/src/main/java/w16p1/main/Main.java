package w16p1.main;

import w16p1.dataBase.DAO;
import w16p1.dataObjects.*;
import w16p1.service.RestaurantService;
import w16p1.service.WaiterService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, SQLException {
        DAO dao = new DAO();
        dao.createDatabase();

        Restaurant restaurant = new Restaurant(10, 1);
        RestaurantService restaurantService = new RestaurantService(restaurant, dao);
        WaiterService waiterService = new WaiterService(dao);
        Client client = restaurantService.newClient(120, 1);
        Item item = new Item("Cola", 5, 1);
        Order order = waiterService.createOrder(client, item, 1);

        Waiter waiterOne = restaurantService.engageWaiter("Mihai", 1200, order, 1);
        Waiter waiterTwo = restaurantService.engageWaiter("Catalin", 1200, order, 2);
        restaurantService.dismissWaiter(waiterTwo);
        restaurantService.putMoreTables(12);
        restaurantService.removeTables(10);
        waiterService.takeCommand(item, waiterOne, client);
        waiterService.removeItem(item);
        waiterService.getBill(item);
        restaurantService.changeItemPrice(item, 6);

        dao.dropTable();
        dao.closeConnection();
    }
}
