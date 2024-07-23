package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List findAnagrams(String s, String p) {
        List res = new ArrayList<>();

        if (s == null || s.length() == 0) return res;

        char[] pa = p.toCharArray();
        Arrays.sort(pa);
        for (int i = 0; i < s.length()-p.length()+1; i++) {
            char[] sub = s.substring(i, i+p.length()).toCharArray();
            Arrays.sort(sub);
            if (isSame(sub, pa)) {
                res.add(i);
            }
        }

        return res;
    }

    static boolean isSame(char[] a1, char[] a2) {
        int i = 0;
        while (i < a1.length) {
            if (a1[i] != a2[i]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
