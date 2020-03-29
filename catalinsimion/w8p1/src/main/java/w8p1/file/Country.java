package w8p1.file;

public class Country implements  Comparable{
    private String name;
    private String capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getCapital() {
        return capital;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country: " + "name= " + name + ", capital='" + capital;
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Country)o).getName());
    }
}
