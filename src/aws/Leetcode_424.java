package aws;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_424 {

    public static void main(String[] args) {
        System.out.println(new Leetcode_424().characterReplacement("ABAB", 6));
    }

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

//    public int characterReplacement(String s, int k) {
//        int result = 0;
//
//        Map<Character, Integer> data = new HashMap<>();
//
//        for (int i = 0, j = 0; i < s.length(); i++) {
//            int value = data.getOrDefault(s.charAt(i), 0) + 1;
//            data.put(s.charAt(i), value);
//
//            int count = data.values().stream().mapToInt(Integer::intValue).sum();
//            if(isValid(data, k, count)) {
//                result = Math.max(result-1, count);
//
//            } else {
//                int valueJ = data.getOrDefault(s.charAt(j), 0);
//                if (valueJ > 1) {
//                    data.put(s.charAt(j), value - 1);
//                } else {
//                    data.remove(s.charAt(j));
//                }
//                j++;
//            }
//        }
//
//
//        return result;
//    }
//
//    private boolean isValid(Map<Character, Integer> data, int k, int count) {
//        int value = data.values().stream().max(Comparator.naturalOrder()).get();
//        return count - value <= k;
//    }
}
