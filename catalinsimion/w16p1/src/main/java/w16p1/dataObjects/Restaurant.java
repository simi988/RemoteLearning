package w16p1.dataObjects;

import w16p1.Anotations.Column;
import w16p1.Anotations.Table;

import java.util.List;
@Table(name = "TBL_RESTAURANT")
public class Restaurant {
    @Column(name = "Waiter")
    List<Waiter> waiterList;
    @Column(name = "NUMBER_OF_TABLES")
    int numberOfTables;
    @Column(name = "ID",isPrimaryKey = true)
    int id;

    public Restaurant(List<Waiter> waiterList, int numberOfTables, int id) {
        this.waiterList = waiterList;
        this.numberOfTables = numberOfTables;
        this.id = id;
    }

    public List<Waiter> getWaiterList() {
        return waiterList;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }
}
