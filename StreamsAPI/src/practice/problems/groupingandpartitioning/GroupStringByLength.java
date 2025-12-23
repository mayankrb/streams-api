package practice.problems.groupingandpartitioning;

import java.util.List;
import java.util.Arrays;

public class GroupStringByLength {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "at", "dog", "cat", "bird",
                "up", "down", "left", "neat",
                "in", "fast", "slow", "jump",
                "run", "walk", "skip", "hope",
                "joy", "sad", "east", "west",
                "hot", "cold", "wind", "rain",
                "sun", "moon", "star", "cloud",
                "fog", "mist"
        );
        System.out.println(strings);
    }
}
