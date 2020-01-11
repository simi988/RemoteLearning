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


    public String selfDescribe() {
        String message = "Bun venit";
        return message;
    }
}
