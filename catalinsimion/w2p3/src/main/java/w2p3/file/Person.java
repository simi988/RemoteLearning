package w2p3.file;

public class Person {
    public static String birthday;
    public static String name;
    public static String address;

    {
        System.out.println("this is a Person block");
    }

    static {
        System.out.println("this is a Person static block");
    }

    public Person(String name, String birthday, String address) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        System.out.println("person builder");
    }
}
