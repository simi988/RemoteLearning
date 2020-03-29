package w8p2.file;

public class Card {

    private int number;
    private Suite suite;

    public Card(int number, Suite suite) {
        this.number = number;
        this.suite = suite;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }
}

