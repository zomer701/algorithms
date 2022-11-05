package google;

import java.util.Collections;
import java.util.HashMap;

public class Leetcode_340 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_340().lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        int leftPointer = 0, rightPointer = 0, max = 0;
        var set = new HashMap<Character, Integer>();

        while (rightPointer < s.length()) {

            set.put(s.charAt(rightPointer), rightPointer    ++);

            if (set.size() == k + 1) {
                int lowestIndex = Collections.min(set.values());
                set.remove(s.charAt(lowestIndex));
                leftPointer = lowestIndex + 1;
            }

            max = Math.max(max, rightPointer - leftPointer);
        }

        return max;
    }
}
