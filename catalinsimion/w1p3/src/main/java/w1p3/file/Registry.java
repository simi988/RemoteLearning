package w1p3.file;

import java.util.ArrayList;
import java.util.List;

public class Registry {

    String create;
    private String registryName;
    private List<Domain> domains = new ArrayList<>();

    public Registry(String registryName) {
        this.registryName = registryName;
    }

    public String createDomain(Domain domain) {

            if (!domains.contains(domain)) {
                domains.add(domain);
                create = "created successfully";
            } else

                create = "Busy domain";
            return create;


        }
    }
