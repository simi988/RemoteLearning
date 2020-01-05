public class Person {
    public String firstName;
    public String surName;
    public static final int FIRST_POSITION = 0;
    public static final int SECOND_POSITION = 1;

    Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    Person(String fullName) {
        String[] splitName = fullName.split(" ");
        this.firstName = splitName[FIRST_POSITION];
        this.surName = splitName[SECOND_POSITION];
    }

    public String toString() {
        return firstName + " " + surName + " ";
    }

}