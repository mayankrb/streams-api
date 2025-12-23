package big_four.consumer;
/*
Problem 1: The Notification Service (Chaining)
Goal: Practice creating a pipeline of side effects.
Task: Create a simple "Notification System" for a banking app.
Setup: Create three Consumer<String> instances:
logTransaction: Prints "LOG: [Message]"
notifyUser: Prints "EMAIL: Sending email for [Message]"
notifyGov: Prints "AUDIT: Reporting [Message] to authorities"
Pipeline: Chain them together using .andThen() into a single consumer called transactionProcessor.
Test: Run transactionProcessor.accept("Transfer $10,000").
Observation: Notice how the exact same string triggers three completely different systems.
 */

import java.util.function.Consumer;

public class NotificationService {
    public static void main(String[] args){
        Consumer<String> logTransaction = message -> System.out.println("LOG: " +  message);
        Consumer<String> notifyUser = message -> System.out.println("EMAIL: Sending email for " + message);
        Consumer<String> notifyGov = message -> System.out.println("AUDIT: Reporting " + message + " to authorities");
        Consumer<String> transactionProcessor = logTransaction.andThen(notifyUser).andThen(notifyGov);
        transactionProcessor.accept("Transfer $10,000");
    }
}
