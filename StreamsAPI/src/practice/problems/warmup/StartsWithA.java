package practice.problems.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/*
Find the first string that starts with "A".
 */
public class StartsWithA {
    public static void main(String[] args) {
        Predicate<String> isNotEmpty = s-> Objects.nonNull(s) && !s.isEmpty();
        Predicate<String> checkFirstChar = s->s.startsWith("A");
        List<String> list = new ArrayList<String>(Arrays.asList("hello", "world", "", null, "java", "abacus", "Alphabet", "Apple"));
        list.stream().filter(isNotEmpty.and(checkFirstChar)).findFirst().ifPresent(System.out::println);
    }
}
