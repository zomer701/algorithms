package aws;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Leetcode_2131 {
    public static void main(String[] args) {
        String[] words = {"bb","bb"};

        System.out.println(longestPalindrome(words));
    }

    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.merge(word, 1, Integer::sum);
        }
        int answer = 0;
        boolean central = false;
        Set<String> skip = new HashSet<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (skip.contains(entry.getKey())) {
                continue;
            }
            String word = entry.getKey();
            int countOfTheWord = entry.getValue();
            // if the word is a palindrome
            if (word.charAt(0) == word.charAt(1)) {
                if (countOfTheWord % 2 == 0) {
                    answer += countOfTheWord;
                } else {
                    answer += countOfTheWord - 1;
                    central = true;
                }
                continue;
                // consider a pair of non-palindrome words such that one is the reverse of another
            }

            String reversedWord = "" + word.charAt(1) + word.charAt(0);
            if (count.containsKey(reversedWord)) {
                answer += 2 * Math.min(countOfTheWord, count.get(reversedWord));
                skip.add(reversedWord);
            }


        }
        if (central) {
            answer++;
        }
        return 2 * answer;
    }
}
