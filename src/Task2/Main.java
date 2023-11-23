package Task2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println("Количество несовершеннолетних: " + persons.stream().filter(e -> e.getAge() < 18).count());
        persons.stream().filter(e -> e.getAge() <= 27).filter(e -> e.getAge() >= 18).map(e -> e.getFamily()).collect(Collectors.toList());
        persons.stream().filter(e -> e.getEducation() == Education.HIGHER)
                .filter(e -> e.getAge() >= 18)
                .filter(e -> e.getSex() == Sex.MAN ? e.getAge() < 65 : e.getAge() < 60)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }
}