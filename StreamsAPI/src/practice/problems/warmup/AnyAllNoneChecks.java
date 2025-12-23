package practice.problems.warmup;

import java.util.List;
/*
Check if any, all, or none of the numbers are even.
 */
public class AnyAllNoneChecks {
    static void check(List<Integer> numbers){
        boolean hasAnyEven = numbers.stream().anyMatch(i->i%2==0);
        boolean hasAllEven = numbers.stream().allMatch(i->i%2==0);
        boolean hasNoneEven = numbers.stream().noneMatch(i->i%2==0);
        System.out.println("Does " + numbers + " have any even number: " + hasAnyEven);
        System.out.println("Does " + numbers + " have all even numbers: " + hasAllEven);
        System.out.println("Does " + numbers + " have none even numbers: " + hasNoneEven);
    }
    public static void main(String[] args) {
        List<Integer> normalList = List.of(1, 2, 3, 4, 5);
        List<Integer> allEvenList = List.of(2, 4, 6, 8, 10);
        List<Integer> allOddList = List.of(1, 3, 5, 7, 9);
        check(normalList);
        check(allEvenList);
        check(allOddList);
    }
}
