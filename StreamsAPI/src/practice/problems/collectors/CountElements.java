package practice.problems.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class CountElements {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Elaine", "Frank", "Grace", "Harry", "Irene", "John");
        long count = names.stream().filter(s->s.length()>5).count();
        System.out.println(count);
    }
}
