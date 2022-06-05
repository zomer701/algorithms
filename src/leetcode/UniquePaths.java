package leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return process(m , n, memo);
    }

    protected int process(int m, int n, Map<String, Integer> memo) {
        System.out.println("m=" + m + "    " + "n=" + n);
            if (m == 0 || n == 0) {
                return 0;
            }

            if (m == 1 && n == 1) {
                return 1;
            }

            String key = m + "," + n;
            if (memo.get(key) != null) {
                return memo.get(key);
            }
            int val = process(m - 1, n, memo) + process(m, n - 1, memo);
            memo.put(key, val);
            return val;
    }
}
