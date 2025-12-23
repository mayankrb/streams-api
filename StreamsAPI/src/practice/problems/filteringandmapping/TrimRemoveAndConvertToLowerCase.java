package practice.problems.filteringandmapping;

import java.util.*;
import java.util.stream.Collectors;


public class TrimRemoveAndConvertToLowerCase {
    public static void main(String[] args){
        // Trim strings, remove empty ones, convert to lowercase.
        List<String> strings = Arrays.asList("Hello", "World", "", null, "   ", "Java    ", "   Programming");
        strings.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s->!s.isEmpty())
                .map(String::toLowerCase)
                .forEach(System.out::println);
        // Practice Question: Given a list of sentences, how would you create a stream that prints
        // out every unique word used across all sentences, sorted alphabetically and in lowercase?
        List<String> sentences = Arrays.asList("Java is fun", "Java is powerful", "Streams are cool");
        sentences.stream()
                .flatMap(s-> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // Practice Question: Using the same list of sentences, can you create a Stream that groups the words by their length?
        sentences = Arrays.asList("Java is fun", "Java is powerful", "Streams are really cool");
        sentences.stream()
                .collect(Collectors.groupingBy(sentence -> sentence.split(" ").length))
                .forEach((k,v)->System.out.println(k + ": " + v));

        // Practice Question: Go back to the very first goal: grouping individual words by their length. But this time,
        // instead of a Map<Integer, List<String>>, we want a Map<Integer, Long> that tells me how many words have that specific length.
        sentences.stream()
                .flatMap(s-> Arrays.stream(s.split(" ")))
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + ": " + v));

        // same as the previous one, but combine the words of the same length using ", ".
        sentences.stream()
                .flatMap(s-> Arrays.stream(s.split(" ")))
                .collect(Collectors.groupingBy(String::length, Collectors.mapping(String::toUpperCase, Collectors.joining(", "))))
                .forEach((k, v) -> System.out.println(k + ": " + v));

        // Practice Question: Let's apply this to strings! Given our list of words, can you use .reduce() to find the longest word in the entire stream?
        int longestWordLength = sentences.stream()
                .flatMap(s->Arrays.stream(s.split(" ")))
                .mapToInt(String::length)
                .reduce(0, Math::max);
        System.out.println("Longest word length: " + longestWordLength);
    }
}
