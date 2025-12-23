package practice.problems.reducingandaggregation;

import java.util.List;
//Sum all numbers using reduce.
public class SumOfAllNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
