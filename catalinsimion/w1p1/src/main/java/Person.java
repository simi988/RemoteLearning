
public class Person {
    private String firstName = new String();
    private String lastName = new String();
    private String yearBirthday = new String();
    private String yearDead = new String();

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getyearBirthday() {
        return yearBirthday;
    }

    public void setyearBirthday(String yearBirthday) {
        this.yearBirthday = yearBirthday;
    }

    public String getyearDead() {
        return yearDead;
    }

    public void setyearDead(String yearDead) {
        this.yearDead = yearDead;
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

        if (p.getfirstName().equals(firstName) &&
                p.getlastName().equals(lastName) &&
                p.getyearBirthday().equals(yearBirthday) &&
                p.getyearDead().equals(yearDead)) {
            return true;
        }
        return false;
    }
    public String toString(){
return firstName+" "+lastName+" ("+yearBirthday+" "+yearDead+" )";
    }
}
