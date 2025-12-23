package practice.problems.collectors;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectToListSet {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>(List.of("Alice", "Bob", "Alice", "Charlie"));
        List<String> collectedNamesList = names.stream()
                .collect(Collectors.toList());
        System.out.println(collectedNamesList);
        Set<String> collectedNamesSet = names.stream()
                .collect(Collectors.toSet());
    }
}
