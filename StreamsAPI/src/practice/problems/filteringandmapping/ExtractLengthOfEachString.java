package practice.problems.filteringandmapping;

import java.util.List;
/*
    Extract lengths of each string.
 */
public class ExtractLengthOfEachString {
    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "World", "Java");
        strings.stream()
                .mapToInt(String::length)
                .forEach(System.out::println);
    }
}
