package w16p1.dataObjects;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;

import java.util.List;

@Table(name = "TBL_WAITER")
public class Waiter {
    @Column(name = "WAITER_NAME")
    String name;
    @Column(name = "WAITER_SALARY")
    double salary;
    @Column(name = "WAITER_ORDER")
    List<Order> orderList;
    @Column(name = "ID",isPrimaryKey = true)
    int id;

    public Waiter(String name, double salary, List<Order> orderList, int id) {
        this.name = name;
        this.salary = salary;

        this.orderList = orderList;
        this.id = id;
    }
}
