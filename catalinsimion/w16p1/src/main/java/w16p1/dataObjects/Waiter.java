package w16p1.dataObjects;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;

@Table(name = "TBL_WAITER")
public class Waiter {
    @Column(name = "WAITER_NAME")
    String name;
    @Column(name = "WAITER_SALARY")
    double salary;
    @Column(name = "ORDER")
    Order order;
    @Column(name = "ID", isPrimaryKey = true)
    long id;

    public Waiter(String name, double salary, Order order, long id) {
        this.name = name;
        this.salary = salary;
        this.order = order;
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
