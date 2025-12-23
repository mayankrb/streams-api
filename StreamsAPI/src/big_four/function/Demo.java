package big_four.function;

import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
        Function<String, Integer> getLength = String::length;
        Function<Integer, Integer> multiplyByTen = x -> x * 10;
        Function<String, Integer> stringToScore = getLength.andThen(multiplyByTen);
        String testString = "Functional";
        System.out.println("Score for String "+ testString + ": "+ stringToScore.apply(testString));
    }
}
