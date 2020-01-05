import java.util.ArrayList;
import java.util.List;

public class Customer {
    public static final int FIRST_POSITION = 0;
    private String customerName;
    private List<Reseller> resellers = new ArrayList<>();

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public void buy(Domain domain) {
        Reseller reseller = resellers.get(FIRST_POSITION);

        reseller.buy(domain);
    }

    public void addReseller(Reseller reseller) {
        resellers.add(reseller);
    }
}
