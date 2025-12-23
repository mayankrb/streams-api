package practice.problems.warmup;

import java.util.List;

/*
    Convert a List<String> to uppercase.
 */
public class StringsToUpperCase {
    public static void main(String[] args) {
        List<String> list = List.of("hello", "world", "java");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
