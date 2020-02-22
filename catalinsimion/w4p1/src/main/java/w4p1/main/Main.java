package w4p1.main;

import w4p1.file.DispatchOperator;
import w4p1.file.TaxiDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<TaxiDriver> drivers = new ArrayList<TaxiDriver>();
        drivers.add(new TaxiDriver(321,3,"Str.Macului"));
        drivers.add(new TaxiDriver(322,2,"Str.Micsunele"));
        DispatchOperator operator = new DispatchOperator("Dan", drivers);

        operator.dispatch("Calea Bucuresti nr. 6");
        operator.dispatch("Calea Severinului");
    }
    }

