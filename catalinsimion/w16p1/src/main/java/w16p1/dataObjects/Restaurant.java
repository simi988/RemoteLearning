package w16p1.dataObjects;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;

@Table(name = "TBL_RESTAURANT")
public class Restaurant {
    @Column(name = "Waiter")
    Waiter waiter;
    @Column(name = "NUMBER_OF_TABLES")
    int numberOfTables;
    @Column(name = "ID", isPrimaryKey = true)
    int id;

    public Restaurant(int numberOfTables, int id) {
        this.numberOfTables = numberOfTables;
        this.id = id;
    }

    public Restaurant(Waiter waiter, int numberOfTables, int id) {
        this.waiter = waiter;
        this.numberOfTables = numberOfTables;
        this.id = id;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }
}
