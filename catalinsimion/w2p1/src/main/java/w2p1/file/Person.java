package w2p1.file;

public class Person {
    private String firstName;
    private String surName;
    public static final int FIRST_NAME_POSITION = 0;
    public static final int SUR_NAME_POSITION = 1;

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public Person(String fullName) {
        String[] splitName = fullName.split(" ");
        this.firstName = splitName[FIRST_NAME_POSITION];
        this.surName = splitName[SUR_NAME_POSITION];
    }

    public String toString() {
        return firstName + " " + surName + " ";
    }

}