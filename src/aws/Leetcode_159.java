package aws;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_159 {

    public static void main(String[] args) {
        String  s = "a";
        System.out.println(new Leetcode_159().lengthOfLongestSubstringTwoDistinct(s));
    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> memo = new HashMap<>();
        int end = 0;
        char[] values = s.toCharArray();
        int result = 0;
        for (int i = 0; i < values.length; i ++) {
            char val = values[i];
            memo.merge(val, 1, Integer::sum);

            while (memo.size() > 2 && end < i) {
                char point = values[end++];
                int currentValue = memo.get(point);
                currentValue = currentValue-1;
                if (currentValue == 0) {
                    memo.entrySet().removeIf(entry -> point == entry.getKey());
                } else {
                    memo.put(point, currentValue);
                }
            }

            result = Math.max(result, i - end + 1);


        }

        return result;
    }
}
