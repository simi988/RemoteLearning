package w1p1.file;

import java.util.Objects;

public class Person {
    private String firstName = new String();
    private String lastName = new String();
    private String yearBirthday = new String();
    private String yearDead = new String();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getYearBirthday() {
        return yearBirthday;
    }

    public void setYearBirthday(String yearBirthday) {
        this.yearBirthday = yearBirthday;
    }

    public String getYearDead() {
        return yearDead;
    }

    public void setYearDead(String yearDead) {
        this.yearDead = yearDead;
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, yearBirthday, yearDead);
    }

    @Override
    public boolean equals(Object person) {
        if (person == this) {
            return true;
        }
        if (person == null || !(person instanceof Person)) {
            return false;
        }
        Person p = (Person) person;
        if (p.getFirstName().equals(firstName) &&
                p.getLastName().equals(lastName) &&
                p.getYearBirthday().equals(yearBirthday) &&
                p.getYearDead().equals(yearDead)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + yearBirthday + " " + yearDead + " )";
    }
}