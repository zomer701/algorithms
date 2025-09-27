package apple;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3 {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> unique = new HashSet<>();

        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!unique.contains(s.charAt(j))) {
                unique.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                unique.remove(s.charAt(i++));
            }
        }

        return result;
    }
}
