package w13p4.PersonInfoTest;

import w13p4.Person.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonInfo {
    public List<Person> showAgePersons(List<Person> listToProcess) {
        checkNullList(listToProcess);
        List<Person> processed = listToProcess
                .stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());
        return processed;
    }

    public Optional<Person> showTheOldestPerson(List<Person> listToProcess) {
        checkNullList(listToProcess);
        Optional<Person> reduce = listToProcess
                .stream()
                .reduce((person1, person2) -> {
                    if (person1.getAge() > person2.getAge()) {
                        return person1;
                    } else {
                        return person2;
                    }
                });

return reduce;
    }

    public  Optional<Person> showIfPersonsAreYoungerThan80(List<Person> listToProcess) {
        checkNullList(listToProcess);
        Optional<Person> optionalPerson = listToProcess.stream().filter(person -> person.getAge() > 80).findAny();
        if (!optionalPerson.isPresent()) {
            System.out.println("YES");
        }
        return optionalPerson;
    }

    public Map<Integer,List<String>> showMappedPersonsByAge(List<Person> listToProcess){
        checkNullList(listToProcess);
        Map<Integer,List<String>> mappedPersons =
                listToProcess
                        .stream()
                        .collect(Collectors.groupingBy(person -> person.getAge(),
                                Collectors.mapping(person -> person.getName(), Collectors.toList())));

        return mappedPersons;
    }

    private void checkNullList(List<Person> listToTest) {
        if (listToTest == null) {
            throw new IllegalArgumentException("The list is null, add elements!");
        }
    }
}
