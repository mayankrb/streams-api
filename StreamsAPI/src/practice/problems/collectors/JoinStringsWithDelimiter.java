package practice.problems.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class JoinStringsWithDelimiter {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Elaine", "Frank", "Grace", "Harry", "Irene", "John");
        String joinedNames = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joinedNames);
    }
}
