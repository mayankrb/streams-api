package big_four.function;

import java.util.function.Function;
/*
    Problem 1: The Currency Converter
    Goal: Practice basic transformation and formatting.
    Task: Create a Function<Double, String> named usdToEuro.
    Logic: Multiply the input (USD) by 0.92 (conversion rate) and return the result as a formatted String: "€[value]".
    Bonus: Try to ensure the Euro value is rounded to two decimal places (Hint: use String.format("%.2f", value)).
*/
public class CurrencyConverter {
    public static void main(String[] args) {
        Function<Double, Double> dollarToEuro = dollar -> dollar * 0.92;
        Function<Double, String> formattedValue = val -> String.format("%.2f", val);
        Function<String, String> addCurrencySymbol = val -> "€[" + val + "]";
        Function<Double, String> usdToEuro = dollarToEuro.andThen(formattedValue).andThen(addCurrencySymbol);
        double dollarValue = 100.0;
        System.out.println("Converting "+ dollarValue + " into Euros");
        System.out.println("Converted Value: " + usdToEuro.apply(100.0));
    }
}
