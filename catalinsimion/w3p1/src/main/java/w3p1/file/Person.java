package w3p1.file;

public abstract class Person {

    public abstract String getBirthDate(String birthDate);

    public abstract String selfDescribe(String fullName, String birthDate);
    public abstract String selfDescribe(String firstName,String surName, String birthDate);


    private static String birthDate;
    private String firstName;
    private String surName;
    public static final int FIRST_NAME_POSITION = 0;
    public static final int SUR_NAME_POSITION = 1;

    public Person(String firstName, String surName, String birthDate) {
        this.firstName = firstName;
        this.surName = surName;

        this.birthDate = birthDate;

    }

    public Person(String fullName, String birthDate) {
        String[] splitName = fullName.split(" ");
        this.firstName = splitName[FIRST_NAME_POSITION];
        this.surName = splitName[SUR_NAME_POSITION];

        this.birthDate = birthDate;

    }




}