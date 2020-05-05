package w13p4.main;

import w13p4.file.Person;

public class Main {
    public static void main(String[] args) {
        Person person=new Person();
        person.older();
        System.out.println();
        person.oldest();
        System.out.println();
        person.younger();
        System.out.println();
        person.group();
    }
}
