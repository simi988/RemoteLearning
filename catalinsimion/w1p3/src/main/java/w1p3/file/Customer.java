package w1p3.file;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public static final int FIRST_POSITION = 0;
    private String customerName;
    private List<Reseller> resellers = new ArrayList<>();

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public String buy(Domain domain) {
        Reseller reseller = resellers.get(FIRST_POSITION);
        return reseller.createDomain(domain);
    }

    public void addReseller(Reseller reseller) {
        resellers.add(reseller);
    }
}
