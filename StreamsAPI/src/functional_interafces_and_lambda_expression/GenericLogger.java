package functional_interafces_and_lambda_expression;

/*
Problem 3: The Generic Logger
Goal: Understand how Generics work with Functional Interfaces.
Create a Generic functional interface Formatter<T> with a method String format(T item).
Create a lambda for Formatter<Integer> that returns the string: "Value: [number]".
Create a lambda for Formatter<LocalDate> that returns just the year of the date.
Challenge: Try to write a method reference for the Integer formatter if possible (Hint: look at String.valueOf()).
 */

import java.time.LocalDate;

@FunctionalInterface
interface Formatter<T>{
    String format(T t);
}

public class GenericLogger {
    static<T> void applyTransformation(Formatter<T> processor, T item, String processorName){
        System.out.println(String.valueOf(item));
        System.out.println("Processor name: " +processorName);
        System.out.println(processor.format(item));
    }
    public static void main(String[] args) {
        Formatter<Integer> integerFormatter = String::valueOf;
        Formatter<LocalDate> dateFormatter = d -> String.valueOf(d.getYear());
        LocalDate date = LocalDate.now();
        applyTransformation(integerFormatter, 10, "integerFormatter");
        applyTransformation(dateFormatter, date, "dateFormatter");
    }
}

