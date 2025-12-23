package practice.problems.reducingandaggregation;

import java.util.List;
import java.util.Optional;

public class ConcatenateListOfStringWithCommas {
    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "World", "Java", "Programming", "is", "fun");
        Optional<String> joinedString = strings.stream()
                .reduce((s1, s2) -> s1 + ", " + s2);
        System.out.println(joinedString.get());
    }
}
