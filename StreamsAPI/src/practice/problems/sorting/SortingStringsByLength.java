package practice.problems.sorting;

import java.util.List;
// Sort strings by length.
public class SortingStringsByLength {
    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "World!", "Java", "Programming");
        strings.stream()
                .sorted((s1, s2)->s1.length()-s2.length()) // .sorted(Comparator.comparingInt(String::length)) another way to implement it
                .forEach(System.out::println);
    }
}
