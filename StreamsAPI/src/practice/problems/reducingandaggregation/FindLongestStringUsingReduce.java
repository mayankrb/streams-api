package practice.problems.reducingandaggregation;

import java.util.List;
import java.util.Optional;

public class FindLongestStringUsingReduce {
    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "World", "Java", "Programming", "is", "fun");
        Optional<String> longestString = strings.stream()
                .reduce((x, y) -> x.length() > y.length() ? x : y);
        System.out.println(longestString.get());
    }
}
