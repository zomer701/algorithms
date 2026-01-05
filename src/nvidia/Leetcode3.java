package nvidia;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> memo = new HashSet<>();

        int result = 0;
        int prev = 0;

        for (int i = 0; i <  s.length(); i++) {

            char c = s.charAt(i);


            while (memo.contains(c)) {
                memo.remove(s.charAt(prev));
                prev++;
            }

            memo.add(c);
            result = Math.max(result, i - prev + 1);
        }

        return result;
    }
}
