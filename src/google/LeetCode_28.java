package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_28 {
    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issip";
        System.out.println(new LeetCode_28().strStr(s1, s2));
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() < 1 || needle.length() < 1 || needle.length() > haystack.length()) {
            return -1;
        }

        int start = needle.charAt(0);
        int hayLength = haystack.length();
        int needLength = needle.length();
        for (int i = 0; i < hayLength; i++) {
           if (haystack.charAt(i) == start) {
               if (needLength > hayLength - i ) {
                   return -1;
               }

               if (isSrt(haystack, needle, i)) {
                   return i;
               }
           }
        }

        return -1;
    }

    private boolean isSrt(String haystack, String needle, int index) {
        if (needle.length() == 1) {
            return true;
        }

        for (int i = 1; i < needle.length(); i++) {
            if (haystack.charAt(index+i) != needle.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
