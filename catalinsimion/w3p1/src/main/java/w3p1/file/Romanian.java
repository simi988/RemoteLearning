package w3p1.file;

public class Romanian extends Person {



    public Romanian(String firstName, String surName, String birthDate) {
        super(firstName, surName, birthDate);
    }

    public Romanian(String fullName, String birthDate) {
        super(fullName, birthDate);
    }

    public String getBirthDate(String birthDate) {
        return birthDate;
    }


    public String selfDescribe(String fullName, String birthDate) {

        String message = "Eu sunt ";
        String message2=" si am ";
        String message3=" ani!";
        return message+ fullName+message2+getBirthDate(birthDate)+message3;
    }
    public String selfDescribe(String firstName,String surName, String birthDate) {

        String message = "Eu sunt ";
        String message2=" si am ";
        String message3=" ani!";
        return message+ firstName+surName+message2+getBirthDate(birthDate)+message3;
    }
}
