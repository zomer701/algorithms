package aws;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_5 {
    private int lo, maxLen;
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i); /* Odd length */
            extendPalindrome(s, i, i + 1); /* Even length */
        }

        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        /*
            1. Must be inbound
            2. Expanding two chars must be the same till the pair of char is not.
         */
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (k - j - 1 > maxLen) { /* Update the lo and high! Mind the index */
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
