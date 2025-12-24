package practice.problems.faltmap;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Employee {
    String name;
    List<String> skills;
    Employee(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }
    Stream<String> streamSkills() { return skills.stream(); }
    @Override
    public String toString() { return name + ": " + skills; }
}

public class FlatMapPractice {
    public static void main(String[] args) {
        // Flatten List<List<Integer>> into one list.
        List<List<Integer>> nestedList = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        List<Integer> flattenedList = nestedList.stream().flatMap(List::stream).toList();
        System.out.println(flattenedList);

        // Get unique characters from list of words.
        List<String> words = List.of("Hello", "World", "Java", "Programming");
        List<Character> uniqueCharacters = words.stream().flatMap(word->word.chars().mapToObj(c->(char)c)).distinct().collect(toList());
        System.out.println(uniqueCharacters);

        // Given employees with list of skills → unique skills.
        List<Employee> employees = List.of(new Employee("John", List.of("Java", "Python")), new Employee("Alice", List.of("Java", "Python", "C++")));
        List<String> uniqueSkills = employees.stream().flatMap(Employee::streamSkills).distinct().toList();
        System.out.println(uniqueSkills);

        // Count total number of elements in nested lists.
        List<List<Integer>> nestedList2 = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        long count = nestedList2.stream().flatMap(List::stream).count();
        System.out.println("Number of elements: " + count);

        // Find words longer than 3 characters across all sentences.
        List<List<String>> sentences = List.of(List.of("Hello", "World"), List.of("Java", "Programming"), List.of("I", "love", "Java"));
        List<String> longWords = sentences.stream().flatMap(List::stream).filter(word->word.length()>3).toList();
        System.out.println(longWords);
    }
}
