package w13p4.PersonFormatsTest;

import org.junit.Test;
import w13p4.Person.Person;
import w13p4.PersonFormator.PersonFormats;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonFormatsTest {
    @Test
    public void convertPersons() {
        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        PersonFormats personFormats = new PersonFormats();
        List<Person> people = personFormats.convertPersons(persons);
        assertEquals(6, people.size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void convertPersonsNullList() {
        PersonFormats personFormats = new PersonFormats();
     personFormats.convertPersons(null);

    }
}
