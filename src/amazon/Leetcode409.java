package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode409 {
    public static void main(String[] args) {
       // System.out.print(0%2);
        System.out.print(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        Set<Character> characterSet = new HashSet<>();
        int res = 0;

        // Loop over characters in the string
        for (char c : s.toCharArray()) {
            // If set contains the character, match found
            if (characterSet.contains(c)) {
                characterSet.remove(c);
                // add the two occurrences to our palindrome
                res += 2;
            } else {
                // add the character to the set
                characterSet.add(c);
            }
        }

        // if any character remains, we have at least one unmatched
        // character to make the center of an odd length palindrome.
        if (!characterSet.isEmpty()) res++;

        return res;
    }

}
