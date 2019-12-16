
public class Person {
    private String FirstName = new String();
    private String LastName = new String();
    private String YearBirthday = new String();
    private String YearDead = new String();

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getYearBirthday() {
        return YearBirthday;
    }

    public void setYearBirthday(String yearBirthday) {
        YearBirthday = yearBirthday;
    }

    public String getYearDead() {
        return YearDead;
    }

    public void setYearDead(String yearDead) {
        YearDead = yearDead;
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

        if (p.getFirstName().equals(FirstName) &&
                p.getLastName().equals(LastName) &&
                p.getYearBirthday().equals(YearBirthday) &&
                p.getYearDead().equals(YearDead)) {
            return true;
        }
        return false;
    }
}
