package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] data = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new MinimumPathSum().minPathSum(data));
    }

    public int minPathSum(int[][] grid) {
        Map<String, Integer> memo = new HashMap<>();
        return process(0, 0, memo, grid);
    }

    protected int process(int m, int n, Map<String, Integer> memo, int[][] grid) {
        System.out.println("m=" + m + "    " + "n=" + n);
        if (m == grid.length  || n == grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (m == grid.length - 1  && n == grid[0].length - 1) {
            return grid[m][n];
        }

        String key = m + "," + n;
        if (memo.get(key) != null) {
            return memo.get(key);
        }

        int val = grid[m][n] + Math.min(process(m + 1, n, memo, grid), process(m, n + 1, memo, grid));

        memo.put(key, val);
        return val;
    }
}
