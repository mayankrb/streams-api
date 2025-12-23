package practice.problems.limitingandskipping;

import java.util.List;
// Skip first 3 and take next 5.
public class SkipFirst3TakeNext5 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .skip(3)
                .limit(5)
                .forEach(System.out::println);
    }
}
