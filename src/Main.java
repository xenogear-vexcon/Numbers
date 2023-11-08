
import Task2.Education;
import Task2.Person;
import Task2.Sex;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        Task 1
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> finalList = new LinkedList<>(intList);
        finalList.removeIf(e -> e <= 0 || e % 2 != 0);
//        finalList.removeIf(e -> e % 2 != 0);
        Collections.sort(finalList);
        for (int e : finalList) {
            System.out.println(e);
        }

        System.out.println("-------------------");
        System.out.println("-------------------");

//        Task 2
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
        persons.stream()
            .filter(e -> e.getEducation() == Education.HIGHER)
            .filter(e -> e.getAge() >= 18)
            .filter(e -> e.getSex() == Sex.MAN ? e.getAge() < 65 : e.getAge() < 60)
            .sorted(Comparator.comparing(Person::getFamily))
            .collect(Collectors.toList());
    }
}
