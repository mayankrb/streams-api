package functional_interafces_and_lambda_expression;

/*
Problem 1: The String Scrambler
Goal: Create a custom functional interface to modify strings in different ways.
Create a functional interface named StringProcessor with a single method String process(String s).
In your main method, create a lambda that converts a string to all lowercase.
Create a second lambda that reverses the string.
Create a method applyTransformation(String target, StringProcessor processor) that executes the logic and print the results for "JavaRocks".
*/

@FunctionalInterface
interface StringProcessor {
    String process(String str);
}


public class StringScrambler {
    static void applyTransformation(String target, StringProcessor processor) {
        System.out.println(processor.process(target));
    }
    public static void main(String[] args) {
        StringProcessor lowerCaseProcessor = String::toLowerCase;
        StringProcessor reverseProcessor = s->String.valueOf(new StringBuilder(s).reverse());
        applyTransformation("JavaRocks", lowerCaseProcessor);
        applyTransformation("JavaRocks", reverseProcessor);

    }
}