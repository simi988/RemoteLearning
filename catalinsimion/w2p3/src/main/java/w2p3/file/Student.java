package w2p3.file;

public class Student extends Person {
    String faculty;
    String specialty;
    String year;

    public Student(String faculty, String specialty, String year) {
        super(name, birthday, address);
        this.faculty = faculty;
        this.specialty = specialty;
        this.year = year;
        System.out.println("constructor Student");
    }

    @Override
    public String toString() {
        System.out.println("toString");
        return name + " " + birthday + " " + address + " " + faculty + " " + specialty + " " + year + " ";
    }
}
