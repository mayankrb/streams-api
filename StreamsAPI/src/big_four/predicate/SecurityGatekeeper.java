package big_four.predicate;

import java.util.Objects;
import java.util.function.Predicate;

/*
Problem 2: The Security Gatekeeper
Goal: Practice null-safety and defensive programming within Predicates.
Task: Create a Predicate<String> called isValidPassword.
Requirements: The password is valid only if:
It is not null.
It is at least 8 characters long.
It contains at least one digit (Hint: Use s.chars().anyMatch(Character::isDigit)).
Challenge: Ensure that if you pass a null string to isValidPassword.test(), it returns false instead of throwing a NullPointerException.

 */
public class SecurityGatekeeper {
    public static void main(String[] args) {
        Predicate<String> notNull = Objects::nonNull;
        Predicate<String> atLeast8Characters = s -> s.length() >= 8;
        Predicate<String> containsDigit = s -> s.chars().anyMatch(Character::isDigit);
        Predicate<String> validPassword= notNull.and(atLeast8Characters).and(containsDigit);

        // Test cases
        String nullPassword = null;
        String shortPassword = "abc1";
        String noDigitPassword = "abcdefgh";
        String validPasswordTest = "password123";
        String anotherValidPassword = "securePass1";

        System.out.println("Null password is valid: " + validPassword.test(nullPassword));
        System.out.println("Short password is valid: " + validPassword.test(shortPassword));
        System.out.println("No digit password is valid: " + validPassword.test(noDigitPassword));
        System.out.println("Valid password '" + validPasswordTest + "' is valid: " + validPassword.test(validPasswordTest));
        System.out.println("Another valid password '" + anotherValidPassword + "'  is valid: " + validPassword.test(anotherValidPassword));
    }
}
