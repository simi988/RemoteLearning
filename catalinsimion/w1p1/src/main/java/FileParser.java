
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public List<Person> read(String fileName) {
        List<Person> personsons = new ArrayList<>();
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
                person.setFirstName(data[0]);
                person.setLastName(data[1]);
                person.setYearBirthday(data[2]);
                if (data.length < 4) {
                    person.setYearDead(" lives");
                } else {
                    person.setYearDead(data[3]);

                }
                if (!comparePerson(person, personsons)) {
                    personsons.add(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personsons;
    }

    boolean comparePerson(Person person, List<Person> personsons) {
        for (Person p : personsons) {
            if (p.equals(person)) {
                return true;
            }
        }
        return false;
    }

}
