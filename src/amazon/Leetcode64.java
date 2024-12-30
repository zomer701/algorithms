package amazon;

import java.util.HashMap;
import java.util.Map;

public class Leetcode64 {
    private int[][] grid;
    private Map<String, Integer> memo;
    public int minPathSum(int[][] grid) {
        this.memo = new HashMap<>();
        this.grid = grid;
        return process(0, 0);
    }

    private int process(int x, int y) {
        if (x < 0 || y < 0 || x > grid.length -1 || y > grid[0].length -1) {
            return Integer.MAX_VALUE;
        }

        if (x == grid.length - 1  && y == grid[0].length - 1) {
            return grid[x][y];
        }

        String key = x + "," + y;
        if (memo.get(key) != null) {
            return memo.get(key);
        }

        int val = grid[x][y] + Math.min(process(x + 1, y), process(x, y + 1));

        memo.put(key, val);

        return val;

    }
}
