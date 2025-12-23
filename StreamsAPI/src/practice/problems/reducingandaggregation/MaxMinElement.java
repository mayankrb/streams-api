package practice.problems.reducingandaggregation;

import java.util.List;

public class MaxMinElement {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        //max value of the stream
        int max = numbers.stream()
                .reduce(Integer.MIN_VALUE, Math::max);
        System.out.println(max);

        //min value of the stream
        int min = numbers.stream()
                .reduce(Integer.MAX_VALUE, Math::min);
        System.out.println(min);
    }
}
