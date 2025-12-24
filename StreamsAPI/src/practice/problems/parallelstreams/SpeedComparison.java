package practice.problems.parallelstreams;

import java.util.ArrayList;
import java.util.List;

public class SpeedComparison {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 200_000_000; i++) {
            numbers.add(i);
        }

        // 2. Sequential (Heavy Calc)
        long startSeq = System.currentTimeMillis();
        // Just doing a dummy reduction to force the calculation
        double resultSeq = numbers.stream()
                .mapToDouble(n -> Math.sqrt(Math.pow(n, 2) + Math.pow(n + 1, 2)))
                .sum();
        long endSeq = System.currentTimeMillis();
        System.out.println("Sequential Time: " + (endSeq - startSeq) + " ms");

        // 3. Parallel (Heavy Calc)
        long startPar = System.currentTimeMillis();
        double resultPar = numbers.parallelStream() // <--- The only difference
                .mapToDouble(n -> Math.sqrt(Math.pow(n, 2) + Math.pow(n + 1, 2)))
                .sum();
        long endPar = System.currentTimeMillis();
        System.out.println("Parallel Time:   " + (endPar - startPar) + " ms");
    }
    private static void slowTask(int n) {
        try {
            Thread.sleep(1); // Simulate a fast DB call (1ms)
        } catch (InterruptedException e) { }
    }
}
