package big_four.predicate;

import java.util.function.IntPredicate;
import java.util.Random;

/*
Problem 3: Primitive Performance (The Grade Analyzer)
Goal: Use specialized Predicates to avoid the overhead of autoboxing.
Task: Imagine you have an array of 1,000,000 test scores (integers).
Logic: Create an IntPredicate (from java.util.function) called isPassing.
Logic: Create another IntPredicate called isDistinction.

Requirement:
isPassing: Score is 60 or higher.
isDistinction: Score is 90 or higher.
Practice: Combine them to find scores that are Passing but NOT a Distinction.
 */
public class GradeAnalyzer {
    public static void main(String[] args) {
        int[] scores = new int[1000000];
        Random random = new Random();
        int verifiedCount = 0;
        for (int i = 0; i < scores.length; i++) {
            scores[i] = random.nextInt(101);
//            System.out.print(scores[i]+", ");
            if(scores[i]>=60 && scores[i]<90) verifiedCount+=1;
        }
        System.out.println("\n\n------------------------------------\n\n");

        IntPredicate isPassing = score -> score>=60;
        IntPredicate isDistinction = score -> score>=90;
        IntPredicate isNotDistinction = isPassing.and(isDistinction.negate());
        int count = 0;
        for (int score : scores) {
            if(isNotDistinction.test(score)){
//                System.out.print(score+ ", ");
                count+=1;
            }
        }
        System.out.println("\n\n------------------------------------\n\n");
        System.out.println("Verified Count: "+verifiedCount);
        System.out.println("Predicated calculated Count: "+count);
    }
}
