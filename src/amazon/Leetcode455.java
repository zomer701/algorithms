package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode455 {

    public static void main(String[] args) {
        int[] g = {1,2,3}; int [] s = {1,1};
        System.out.print(findContentChildren(g, s));
    }
    // g = [1,2,3], s = [1,1]
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;

        for (int data: g) {
            int l = 0;
            while (l < s.length) {
                if (s[l] >= data) {
                  result++;
                    s[l]=-1;
                    break;
                }

                l++;
            }
        }

        return result;
    }
}
