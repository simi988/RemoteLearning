package w2p3.file;

public class Person {
    public static String birthday;
    public static String name;
    public static String address;

    public Person(String name, String birthday, String address) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        System.out.println("constructor Persoana");
    }
}
