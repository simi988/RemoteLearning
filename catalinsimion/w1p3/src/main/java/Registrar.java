import java.util.ArrayList;
import java.util.List;

public class Registrar {

    public static final int FIRST_POSITION = 0;
    private String registrarName;
    private List<Registry> registrys = new ArrayList<>();

    public Registrar(String registrarName) {
        this.registrarName = registrarName;
    }

    public void buy(Domain domain) {
        Registry registry = registrys.get(FIRST_POSITION);
        registry.buy(domain);
    }

    public void addRegistry(Registry registry) {
        registrys.add(registry);
    }


}