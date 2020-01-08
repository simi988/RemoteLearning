package w1p1.file;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FileParser {
    public static final int FIRST_NAME_POSITION = 0;
    public static final int LAST_NAME_POSITION = 1;
    public static final int YEAR_BIRTHDAY_POSITION = 2;
    public static final int YEAR_DEAD_POSITION = 3;
    public static final int MAX_POSITION = 4;

    public Set<Person> read(String fileName) {
      Set<Person> personages = new LinkedHashSet<Person>();
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
                person.setFirstName(data[FIRST_NAME_POSITION]);
                person.setLastName(data[LAST_NAME_POSITION]);
                person.setYearBirthday(data[YEAR_BIRTHDAY_POSITION]);

                if (data.length < MAX_POSITION) {
                    person.setYearDead(" lives");

                } else {
                    person.setYearDead(data[YEAR_DEAD_POSITION]);

                }

                personages.add(person);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return personages;
    }
}
