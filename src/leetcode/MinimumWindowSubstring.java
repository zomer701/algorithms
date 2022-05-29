package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("aa", "aa"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        String result = "";
        StringBuilder temp = new StringBuilder();

        List<Character> ddd = t.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        for (int i = 0;i<s.length();i++) {
            if (ddd.contains(s.charAt(i)) || temp.length() > 0) {
                temp.append(s.charAt(i));
            }

            List<Character> val = temp.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

            if (val.size() >= ddd.size() && val.containsAll(ddd)) {
                result = (result.length() > 1 && result.length() < temp.length()) ? result : temp.toString();
                temp = new StringBuilder();
            }
        }

        return result;
    }
}
