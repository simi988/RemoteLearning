package w1p3.file;

import java.util.Objects;

public class Domain {

    private String owner;
    private String host;
    private String name;

    public Domain(String owner, String host, String name) {
        this.owner = owner;
        this.host = host;
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        Domain domain = (Domain) o;
        if (domain.getOwner().equals(owner) && domain.getHost().equals(host) && domain.getName().equals(name)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, host, name);
    }
}
