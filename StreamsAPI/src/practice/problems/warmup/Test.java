package practice.problems.warmup;
/*
Problem: "The Sum of Squares of Evens" Given a list of numbers, I want you to:
Keep only the even numbers.
Square each of them (multiply it by itself).
Sum them all up using reduce (or reduce via mapToInt).
 */

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = numbers.stream()
                .filter(i->i%2==0)
                .mapToInt(x->x*x)
                .reduce(0, Integer::sum);
        System.out.println(result);
    }
}
