package practice.problems.warmup;

/*
Filter out empty strings from a list.
 */

import java.util.ArrayList;
import java.util.List;

public class FilterEmptyStrings {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("Hello", "", "World", "Java"));
        strings.stream().filter(s->!s.isEmpty()).forEach(System.out::println);
    }
}
