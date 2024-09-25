package tiktok;

import java.util.HashMap;
import java.util.Map;

public class Leetcode62 {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return process(m , n, memo);
    }

    private int process(int m, int n,  Map<String, Integer> memo) {
        if (m == 1 && n == 1) {
            return 1;
        }

        if (n == 0 || m == 0) {
            return 0;
        }

        if (memo.containsKey(m + "-" + n)) {
            return memo.get(m + "-" + n);
        }


        int value = process(m-1, n, memo) + process(m, n-1, memo);

        memo.put(m + "-" + n, value);

        return value;
    }
}
