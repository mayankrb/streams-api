package practice.problems.filteringandmapping;
/*
Given List<Integer>, return squares of even numbers.
 */

import java.util.ArrayList;
import java.util.List;

public class ReturnSquaresOfEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer>squaresOfEvenNumbers = numbers.stream().filter(i->i%2==0).map(x->x*x).toList();
        System.out.println(squaresOfEvenNumbers);
    }
}
