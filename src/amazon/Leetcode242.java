package amazon;

import java.util.Arrays;

public class Leetcode242 {
    public static void main(String[] args) {
        System.out.println('z'-'a');
   //     Arrays.toString()
    }

    public boolean isAnagram(String s, String t) {
        int[] memo = new int[26];

        for (char sa: s.toCharArray()) {
            memo['z'-sa] = memo['z'-sa]+1;
        }

        for (char sa: t.toCharArray()) {
            memo['z'-sa] = memo['z'-sa]-1;
        }

        for (int i: memo) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
