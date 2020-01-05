
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FileParser {
    public static final int FIRST_NAME_POSITION = 0;
    public static final int LAST_NAME_POSITION = 1;
    public static final int YEAR_BIRTHDAY_POSITION = 2;
    public static final int YEAR_DEAD_POSITION = 3;
    public static final int MAX=4;

    public  HashSet<Person> read(String fileName) {


       HashSet<Person> personsons = new  HashSet<Person>();
        String cvsSplitBy = ",";

        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data;
                data = line.split(cvsSplitBy);
                Person person = new Person();
                person.setfirstName(data[FIRST_NAME_POSITION]);
                person.setlastName(data[LAST_NAME_POSITION]);
                person.setyearBirthday(data[YEAR_BIRTHDAY_POSITION]);

                if (data.length<MAX) {
                    person.setyearDead(" lives");
                } else {
                    person.setyearDead(data[YEAR_DEAD_POSITION]);
                }
                if (!comparePerson(person, personsons)) {
                    personsons.add(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  personsons;
    }

    boolean comparePerson(Person person,  HashSet<Person> personsons) {
        for (Person p : personsons) {
            if (p.equals(person)) {
                return true;
            }

        }
        return false;
    }

}
