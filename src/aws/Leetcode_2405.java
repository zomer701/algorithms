package aws;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_2405 {
    public static void main(String[] args) {
        System.out.println(minPartitions("abacaba"));
    }

    public static int minPartitions(String s) {
        int partition = 0;
        Set<Character> uniqueChars = new HashSet<>();

        for (int value = 0; value < s.length(); value++) {
            var currentChar = s.charAt(value);
            if (uniqueChars.contains(currentChar)) {
                partition++;
                uniqueChars.clear();
            }

            uniqueChars.add(currentChar);
        }

        return partition+1;
    }
}
