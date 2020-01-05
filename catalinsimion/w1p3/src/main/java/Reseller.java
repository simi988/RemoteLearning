import java.util.ArrayList;
import java.util.List;

public class Reseller {

    public static final int FIRST_POSITION = 0;
    private String resellerName;
    private List<Registrar> registrars = new ArrayList<>();

    public Reseller(String resellerName) {

        this.resellerName = resellerName;
    }

    public void buy(Domain domain) {
        Registrar registrar = registrars.get(FIRST_POSITION);
        registrar.buy(domain);
    }

    public void addRegistrar(Registrar registrar) {
        registrars.add(registrar);
    }


}