package aws;

import java.util.Arrays;

public class Leetcode_242 {
    public static void main(String[] args) {
        String s = "rat", t = "car";

        System.out.println(new Leetcode_242().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        Arrays.sort(sA);
        Arrays.sort(tA);
        for (int i = 0; i < sA.length; i++) {
            if (sA[i] != tA[i]) {
                return false;
            }
        }


        return true;
    }
}
