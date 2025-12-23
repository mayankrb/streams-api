package practice.problems.reducingandaggregation;

import java.util.List;
// Product of all numbers
public class ProductOfAllNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println(product);
    }
}
