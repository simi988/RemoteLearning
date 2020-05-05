package w13p4.file;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Person {
    public void older() {

        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        persons
                .stream()
                .map(s -> s.substring(0, 2))
                .filter(s -> Integer.valueOf(s) > 18)
                .forEach(System.out::println);
    }


    public void oldest() {
        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        persons
                .stream()
                .reduce((p1, p2) -> Integer.parseInt(p1.substring(0, 2)) > Integer.parseInt(p2.substring(0, 2)) ? p1 : p2)
                .ifPresent(System.out::println);
    }

    public void younger() {

        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        List<String> collect = persons
                .stream()
                .map(s -> s.substring(0, 2))
                .filter(s -> Integer.valueOf(s) > 80)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            System.out.println("Yes");
        }
    }

    public void group() {
        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        Map<Object, List<String>> collect = persons.
                stream()
                .collect(Collectors.groupingBy(person -> person.substring(0, person.indexOf(":")), Collectors.toList()));

        System.out.println(collect);
    }
}
