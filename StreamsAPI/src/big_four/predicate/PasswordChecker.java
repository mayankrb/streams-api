package big_four.predicate;

import java.util.List;
import java.util.function.Predicate;


public class PasswordChecker {

    public static void main(String[] args) {
        // Individual, reusable rules
        Predicate<String> lengthRule = s -> s.length() >= 8;
        Predicate<String> digitRule = s -> s.matches(".*\\d.*");
        Predicate<String> symbolRule = s -> s.matches(".*[!@#$%^&*()].*");
        Predicate<String> letterRule = s -> s.matches(".*[a-zA-Z].*");

        // Chaining them into one master rule
        Predicate<String> passwordRule = lengthRule
                .and(digitRule)
                .and(symbolRule)
                .and(letterRule);

        List<String> passwords = List.of(
                "weak@1",      // Fails: length
                "PASSWORD@",   // Fails: digit
                "PASSWORD123", // Fails: symbol
                "Pass@123"     // Passes!
        );

        for(String password : passwords) {
            boolean isValid = passwordRule.test(password);
            System.out.println("Password: " + password);
            System.out.println("Result: " + (isValid ? "Valid" : "Invalid"));
            System.out.println("------------------------------------");
        }
    }
}