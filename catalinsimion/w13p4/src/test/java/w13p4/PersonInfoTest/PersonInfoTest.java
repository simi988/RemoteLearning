package w13p4.PersonInfoTest;

import org.junit.Test;

import w13p4.Person.Person;
import w13p4.PersonFormator.PersonFormats;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class PersonInfoTest {
    @Test
public void showAgePersons(){
        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        PersonInfo personInfo=new PersonInfo();
        PersonFormats personFormat=new PersonFormats();
        List<Person> people = personFormat.convertPersons(persons);
        List<Person> personList = personInfo.showAgePersons(people);
        assertEquals(2,personList.size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void showAgePersonsNullList() {
        PersonInfo personInfo = new PersonInfo();
        PersonFormats personFormat = new PersonFormats();
        List<Person> people = personFormat.convertPersons(null);
         personInfo.showAgePersons(people);
    }

    @Test
    public void showTheOldestPerson(){
        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        PersonInfo personInfo=new PersonInfo();
        PersonFormats personFormat=new PersonFormats();
        List<Person> people = personFormat.convertPersons(persons);
        Optional<Person> person = personInfo.showTheOldestPerson(people);

        assertEquals(new Person(21,"Vasile"),person.get());

    }
    @Test(expected = IllegalArgumentException.class)
    public void showTheOldestPersonNullList() {
        PersonInfo personInfo = new PersonInfo();
        PersonFormats personFormat = new PersonFormats();
        List<Person> people = personFormat.convertPersons(null);
       personInfo.showTheOldestPerson(people);

    }

    @Test
    public void  showIfPersonsAreYoungerThan80(){
        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        PersonInfo personInfo=new PersonInfo();
        PersonFormats personFormat=new PersonFormats();
        List<Person> people = personFormat.convertPersons(persons);
        Optional<Person> person = personInfo.showIfPersonsAreYoungerThan80(people);
        Optional<Person>expectedPerson=Optional.empty();
        assertEquals(expectedPerson,person);
    }
    @Test(expected = IllegalArgumentException.class)
    public void  showIfPersonsAreYoungerThan80NullList() {
        PersonInfo personInfo = new PersonInfo();
        PersonFormats personFormat = new PersonFormats();
        List<Person> people = personFormat.convertPersons(null);
         personInfo.showIfPersonsAreYoungerThan80(people);
    }
    @Test
    public void  showMappedPersonsByAge(){
        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        PersonInfo personInfo=new PersonInfo();
        PersonFormats personFormat=new PersonFormats();
        List<Person> people = personFormat.convertPersons(persons);
        Map<Integer, List<String>> integerListMap = personInfo.showMappedPersonsByAge(people);
        assertEquals(5,integerListMap.size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void  showMappedPersonsByAgeNullList() {

        PersonInfo personInfo = new PersonInfo();
        PersonFormats personFormat = new PersonFormats();
        List<Person> people = personFormat.convertPersons(null);
       personInfo.showMappedPersonsByAge(people);
    }
}

