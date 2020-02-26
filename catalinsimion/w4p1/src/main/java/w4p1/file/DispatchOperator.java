package w4p1.file;
import java.util.List;

public class DispatchOperator implements Dispatcher,Person {

    private String name;
    private static List<TaxiDriver> drivers;

    public DispatchOperator(String name, List<TaxiDriver> drivers) {
        this.name = name;
        this.drivers = drivers;
    }

    public void eat() {
        System.out.println("Operator " + name + " eats");
    }

    private TaxiDriver getBestAvailableTaxi() {
        TaxiDriver closesDriver=drivers.get(0);
        for (TaxiDriver driver:drivers){
            if(driver.getTime()<closesDriver.getTime()){
               closesDriver= driver;

            }

        }
        drivers.remove(closesDriver);
        return closesDriver;
    }




    @Override
    public void dispatch(String location) {
        getBestAvailableTaxi().goToAddress(location);

    }
}
