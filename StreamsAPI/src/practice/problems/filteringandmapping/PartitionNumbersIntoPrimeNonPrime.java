package practice.problems.filteringandmapping;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitionNumbersIntoPrimeNonPrime {
    public static void main(String[] args) {
        Predicate<Integer> isPrime = x -> BigInteger.valueOf(x).isProbablePrime(15);
        List<Integer> primes = List.of(2, 3, 5, 7, 11, 961_748_941, 982_451_653, 999_999_893, 999_999_929, 999_999_937 );
        System.out.println("Prime numbers: " + primes);
        List<Integer> nonPrimes = List.of(1, 4, 6, 8, 9, 1_000_000_000, 999_999_996, 999_999_990, 999_999_900, 999_999_800);
        System.out.println("Small non-prime numbers: " + nonPrimes);
        List<Integer> combined = Stream.of(primes, nonPrimes).flatMap(List::stream).distinct().toList();
        System.out.println("Combined: " + combined);
        Map<Boolean, List<Integer>> partitionedNumbers = combined.stream().collect(Collectors.partitioningBy(isPrime, Collectors.mapping(Integer::valueOf, Collectors.toList())));
        System.out.println("partitionedNumbers: " + partitionedNumbers);
    }
}
