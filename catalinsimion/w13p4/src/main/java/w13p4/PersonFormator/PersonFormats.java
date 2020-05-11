package w13p4.PersonFormator;

import w13p4.Person.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonFormats {
    public  List<Person> convertPersons(List<String> listOfPersons){
        checkListForNullPersons(listOfPersons);
        List<Person> convertedPersons = new ArrayList<>();
        for(String iterator : listOfPersons){
            String[] splitterPerson = iterator.split(":");
            convertedPersons.add(new Person(Integer.parseInt(splitterPerson[0]),splitterPerson[1]));
        }
        return convertedPersons;
    }

    private static void checkListForNullPersons(List<String> listToTest){
        if(listToTest == null){
            throw new IllegalArgumentException("The list is null, add elements!");
        }
    }
}