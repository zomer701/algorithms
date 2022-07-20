package leetcode;

import java.util.Arrays;

public class Leetcode_1706 {
    public static void main(String[] args) {
        int [][] matrix = {
                {-1, 1, 1, -1, 1}};

        System.out.println(Arrays.toString(new Leetcode_1706().findBall(matrix)));
    }

    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length, dp [] = new int[n];
        for (int i = 0; i < n; i ++) {
            dp[i] = i;
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (dp[j] == -1)
                    continue;
                if ((dp[j] == 0 && grid[i][dp[j]] == -1) || (dp[j] == n - 1 && grid[i][dp[j]] == 1) || (grid[i][dp[j]] == 1 && grid[i][dp[j] + 1] == -1) || (grid[i][dp[j]] == -1 && grid[i][dp[j] - 1] == 1))
                    dp[j] = -1;
                else
                    dp[j] += grid[i][dp[j]];
            }
        }
        return dp;
    }
}
