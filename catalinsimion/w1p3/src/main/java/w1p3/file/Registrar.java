package w1p3.file;

import java.util.ArrayList;
import java.util.List;

public class Registrar {

    public static final int FIRST_POSITION = 0;
    private String registrarName;
    private List<Registry> registers = new ArrayList<>();

    public Registrar(String registrarName) {
        this.registrarName = registrarName;
    }

    public String createDomain(Domain domain) {
        Registry registry = registers.get(FIRST_POSITION);

        return registry.createDomain(domain);
    }

    public void addRegistry(Registry registry) {
        registers.add(registry);
    }


}