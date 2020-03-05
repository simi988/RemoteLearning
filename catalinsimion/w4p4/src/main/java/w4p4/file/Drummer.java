package w4p4.file;

public class Drummer {
    private Drumset drumset = new Drumset();
    private String name;

    public Drummer(String name) {
        this.name = name;
        System.out.println(name + " is a Drummer");
    }
}
