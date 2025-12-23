package practice.problems.limitingandskipping;

import java.util.Comparator;
import java.util.List;

// get top 3 highest numbers from stream
public class GetTop3HighestNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
    }
}
