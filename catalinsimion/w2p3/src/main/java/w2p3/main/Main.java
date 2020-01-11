package w2p3.main;

import w2p3.file.Person;
import w2p3.file.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Student student;
    public static List<Student> studentList = new ArrayList<>();
    public static Person person;
    public static List<Person> personList = new ArrayList<>();

    public static void addPerson() {
        System.out.println("addPerson");
        person = new Person("Popescu Claudiu", "20.12.2000", "Str.Tufanele");
        personList.add(person);
        System.out.println(person);
    }

    public static void addStudent() {
        System.out.println("addStudent");
        student = new Student("Science", "Informatics", "2");
        studentList.add(student);
        System.out.println(student);
    }

    public static void main(String[] args) {
        addPerson();
        addStudent();


    }

}
