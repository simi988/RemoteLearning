package w3p1.file;

public class English extends Person {
    public English(String firstName, String surName, String birthDate) {
        super(firstName, surName, birthDate);
    }

    public English(String fullName, String birthDate) {
        super(fullName, birthDate);
    }

    @Override
    public String getBirthDate(String birthDate) {
        return birthDate;
    }

    @Override
    public String selfDescribe(String fullName, String birthDate) {
        String message = "I am ";
        String message2=" and I have ";
        String message3=" years old";
        return message+ fullName+message2+getBirthDate(birthDate)+message3;
    }
    @Override
    public String selfDescribe(String firstName,String surName, String birthDate) {

        String message = "Eu sunt ";
        String message2=" si am ";
        String message3=" ani!";
        return message+ firstName+surName+message2+getBirthDate(birthDate)+message3;
    }
}
