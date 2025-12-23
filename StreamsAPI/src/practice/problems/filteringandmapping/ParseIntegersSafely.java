package practice.problems.filteringandmapping;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
/*
Convert List<String> → List<Integer> (parse integers safely).
 */
public class ParseIntegersSafely {
    public static void main(String[] args) {
        Function<String, Optional<Integer>> isInteger = num -> {
            try{
                return Optional.of(Integer.parseInt(num));
            }catch (NumberFormatException e){
                return Optional.empty();
            }
        };
        List<String> numbersMixedWithNonNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "", "5.0", "5", "6", "7", "8", "9", "10", "a", "b", "c"));
        List<Integer> numbersParsed = numbersMixedWithNonNumbers.stream().map(isInteger).flatMap(Optional::stream).toList();
        System.out.println("Initial list: " + numbersMixedWithNonNumbers);
        System.out.println("Numbers parsed: " + numbersParsed);
    }
}
