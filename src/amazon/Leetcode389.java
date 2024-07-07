package amazon;

import java.util.Arrays;

public class Leetcode389 {
    public static void main(String[] args) {

    }

    public static char findTheDifference(String s, String t) {
        char[] sortedS = s.toCharArray();
        char[] sortedT = t.toCharArray();
        Arrays.sort(sortedS);
        Arrays.sort(sortedT);

        // Character by character comparison
        int i = 0;
        while (i < s.length()) {
            if (sortedS[i] != sortedT[i]) {
                return sortedT[i];
            }
            i += 1;
        }

        return sortedT[i];
    }
}
