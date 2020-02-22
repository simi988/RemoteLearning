package w2p3.file;

import java.sql.SQLOutput;

public class Student extends Person {
    String faculty;
    String specialty;
    String year;

    {
        System.out.println("this is a Student block");
    }

    static {
        System.out.println("this is a Student static block");
    }

    public Student(String faculty, String specialty, String year) {
        super(name, birthday, address);
        this.faculty = faculty;
        this.specialty = specialty;
        this.year = year;
        System.out.println("student builder");
    }

    @Override
    public String toString() {
        System.out.println("toString");
        return name + " " + birthday + " " + address + " " + faculty + " " + specialty + " " + year + " ";
    }
    public String getFaculty(){
        System.out.println(faculty);
        return faculty;
    }
}
