import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReadFromFile {
    public static void main(String[] args) {

        HashSet<Person> Personalities = new HashSet<>();
        FileParser fileParser = new FileParser();
        Personalities =  fileParser.read("W1P1input.txt");
        for (Person personality : Personalities) {
            System.out.println(personality.toString());
        }

    }


}

