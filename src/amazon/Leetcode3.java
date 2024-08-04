package amazon;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3 {

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abba"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        Set<Character> temp = new HashSet<>();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (!temp.contains(s.charAt(j))) {
                temp.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                temp.remove(s.charAt(i++));
            }
        }
        return result;
    }
}
