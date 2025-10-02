package apple;

import java.util.HashMap;
import java.util.Map;

public class Leetcode76 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int missing = t.length(); // total chars still needed (including duplicates)
        int left = 0, start = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                int cnt = need.get(c);
                if (cnt > 0) missing--;     // this char satisfied a requirement
                need.put(c, cnt - 1);       // may go negative if extra copies
            }

            while (missing == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char lc = s.charAt(left++);
                if (need.containsKey(lc)) {
                    int cnt = need.get(lc) + 1; // put it back
                    need.put(lc, cnt);
                    if (cnt > 0) {              // we now miss this char
                        missing++;
                    }
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
