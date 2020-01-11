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


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }
        Domain domain = (Domain) o;
        if (owner.equals(owner) && host.equals(host) && name.equals(name)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, host, name);
    }
}
