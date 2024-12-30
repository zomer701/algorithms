package trello;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_338 {
    public static void main(String[] args) {
        System.out.println(countBits(2));
    }

    private static int popCount(int x) {
        int count;
        for (count = 0; x != 0; ++count) {
            x = x & x - 1;
            System.out.println(x);
        }
        return count;
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int x = 0; x <= n; ++x) {
            ans[x] = popCount(x);
        }
        return ans;
    }
}
