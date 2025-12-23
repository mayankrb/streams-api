package practice.problems.sorting;

import java.util.List;

// Sort numbers ascending
public class NumsAscending {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 3, 2, 4, 5);
        nums.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
