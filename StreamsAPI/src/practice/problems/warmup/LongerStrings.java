package practice.problems.warmup;
/*
Count strings longer than 5 characters.
 */

import java.util.ArrayList;
import java.util.List;

public class LongerStrings {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("Hello", "World!", "Welcome", "to", "Java", "Programming"));
        long count = strings.stream().filter(s->s.length()>5).count();
        System.out.println("Number of strings with length more than 5: " + count);
    }
}
