package w8p1.file;

public class Country {
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
}
