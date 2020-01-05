import java.util.ArrayList;
import java.util.List;

public class Registry {

    public static final int FIRST_POSITION = 0;
    private String registryName;
    private List<Domain> domains = new ArrayList<>();

    public Registry(String registryName) {
        this.registryName = registryName;
    }

    public void buy(Domain domain){

        domains.add(domain);
    }




}