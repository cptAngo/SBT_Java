import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.util.function.DoubleUnaryOperator.*;
import static java.util.stream.Collectors.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(new File("1.txt").toPath())
                .stream()
                .map(s -> s.split(" "))
                .flatMap(array -> Arrays.stream(array))
                .collect(groupingBy(identity(), count()))
                .forEach((s -> System.out.println("!!!"+ s)));
    }

    public Set<Integer> filter(List<Person> persons) {
        Set<Integer> ages = new TreeSet<>();
        for (Person person : persons) {
            if (person.getName().equals("Alex")) {

            }
        }
    }

    public Set<Integer> filterJ8(List<Person persons>) {
        persons.stream()
                .filter(person -> person.getName().equals("Alex"))
                .map(person -> person.getAge())
                .collect(toSet());
    }

    public Map<String, List<Person>> groupByName(List<Person> persons) {
        Map<String, List<Person>> nameToPersons = new TreeMap<>();
        for (Person person : persons) {
            if (nameToPersons.get(person.getName()) == null) {
                nameToPersons.put(name, new ArrayList<>());
            }
            nameToPersons.get(name).add(person);
        }
        return nameToPersons;
    }

    public Map<String, List<Person>> groupByNameJ8(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.getAge() > 18)
                        .collect(groupingBy(p -> p.getName()));
    }

    public Map<String, List<Person>> nameToAverage(List<Person> persons) {
        return persons.stream()
                .collect(groupingBy(p -> p.getName(), mapping(Person::getAge, averagingInt(a -> a))));
    }
}

