package big_four.function;

import java.util.function.Function;

/*
Problem 3: The Order Calculator (Chaining Logic)
Goal: Understand the difference between andThen() and compose().
Task: Create two functions:
    addTax: Function<Double, Double> that adds 10% to a value ($x \times 1.1$).
    applyDiscount: Function<Double, Double> that subtracts $5 from a value ($x - 5$).
Comparison:Create taxThenDiscount using addTax.andThen(applyDiscount).
Create discountThenTax using addTax.compose(applyDiscount).
Test: Apply both to an initial price of $100.0. Notice how the final price changes based on the order!
 */
public class OrderCalculator {
    public static void main(String[] args){
        Function<Double, Double> addTax = x -> x * 1.1;
        Function<Double, Double> applyDiscount = x -> x - 5;
        Function<Double, Double> taxThenDiscount = addTax.andThen(applyDiscount);
        Function<Double, Double> discountThenTax = addTax.compose(applyDiscount);
        System.out.println("Price with tax then discount: " + taxThenDiscount.apply(100.0));
        System.out.println("Price with discount then tax: " + discountThenTax.apply(100.0));
    }
}
