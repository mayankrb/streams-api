package practice.problems.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class AverageNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        long count = numbers.stream().count();
        System.out.println(count);
        double intAverage = numbers.stream().collect(Collectors.averagingInt(x->x.intValue()));
        double doubleAverage = numbers.stream().collect(Collectors.averagingDouble(x->x.doubleValue()));
        System.out.println(intAverage);
        System.out.println(doubleAverage);
    }
}
