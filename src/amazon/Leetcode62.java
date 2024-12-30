package amazon;

import java.util.HashMap;
import java.util.Map;

public class Leetcode62 {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return process(m , n, memo);
    }

    private int process(int m, int n, Map<String, Integer> memo) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        if (memo.containsKey(m+"-"+n)) {
            return memo.get(m+"-"+n);
        }

        int result = process(m-1, n, memo);
        memo.put((m-1)+"-"+n, result);

        int result2 = process(m, n-1, memo);
        memo.put(m+"-"+(n-1), result2);

        int val = result2+result;
        memo.put(m+"-"+n, val);
        return val;
    }
}
