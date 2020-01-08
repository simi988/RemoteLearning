package w1p1.main;

import w1p1.file.FileParser;
import w1p1.file.Person;
import java.util.Set;

public class ReadFromFile {
    public static void main(String[] args) {

        Set<Person> personages;
        FileParser fileParser = new FileParser();
        personages = fileParser.read("W1P1input.txt");
        for (Person person : personages) {
            System.out.println(person.toString());
        }

    }
}

