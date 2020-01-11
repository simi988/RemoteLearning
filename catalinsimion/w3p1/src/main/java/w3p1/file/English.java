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
    public String selfDescribe() {
        String message = "Welcome";
        return message;
    }
}
