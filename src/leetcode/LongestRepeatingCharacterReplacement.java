package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> temp = new HashMap<>();
        int result = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
           Character value = s.charAt(i);
           Integer data = temp.getOrDefault(value, 0);
           data++;
           temp.put(value, data);

           while ((i-left+1) - temp.values().stream().max(Comparator.naturalOrder()).get() > k) {
               Integer dataLeft = temp.get(s.charAt(left));
               dataLeft--;
               temp.put(s.charAt(left), dataLeft);
               left++;
           }

           result = Math.max(result, i-left+1);
        }


        return result;
    }
}
