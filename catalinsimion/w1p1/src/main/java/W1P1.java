import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class W1P1 {
    public static void main(String[] args) {

        List<Person> Personalities = new ArrayList<>();
        FileParser fileParser = new FileParser();
        Personalities = fileParser.read("W1P1input.txt");
        for (Person personality : Personalities) {
            System.out.println(personality.getFirstName() + personality.getLastName() + "(" + personality.getYearBirthday() + personality.getYearDead() + ")");
        }

    }


}

