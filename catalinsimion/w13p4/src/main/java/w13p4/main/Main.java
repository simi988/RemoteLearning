package w13p4.main;

import w13p4.Person.Person;
import w13p4.PersonFormator.PersonFormats;
import w13p4.PersonInfoTest.PersonInfo;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        PersonInfo personInfo=new PersonInfo();
        PersonFormats personFormator=new PersonFormats();
        List<Person> people = personFormator.convertPersons(persons);
        System.out.println(personInfo.showAgePersons(people));
        System.out.println( personInfo.showIfPersonsAreYoungerThan80(people));
        System.out.println( personInfo.showTheOldestPerson(people));
        System.out.println(personInfo.showMappedPersonsByAge(people));


    }
}
