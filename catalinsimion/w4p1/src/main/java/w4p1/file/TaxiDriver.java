package w4p1.file;


public class TaxiDriver implements Person, Driver {

    private int taxiNumber;
    private  int time;
    private String taxiLocation;

    public TaxiDriver(int taxiNumber, int time, String taxiLocation) {

        this.taxiNumber = taxiNumber;
        this.time = time;
        this.taxiLocation = taxiLocation;
    }

    public  int getTime() {
        return time;
    }

    public void eat() {
        System.out.println("Driver "+taxiNumber+"  eats");
    }
    public void sleep() {
        System.out.println("Driver " + taxiNumber + " sleeps");
    }

    public String getCurrentLocation() {

        return taxiLocation;
    }
    
        public int goToAddress (String address){

            System.out.println("Driver with taxi number " + taxiNumber + " goes to " + address + " in " + time + " minutes");
            return time; // mock value
        }

    }
