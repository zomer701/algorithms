package amazon;

public class Leetcode1631 {
    int[][] heights;
    boolean[][] memo;
    Integer result = Integer.MAX_VALUE;

    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        this.memo = new boolean[heights.length][heights[0].length];

        proceed(0, 0, 0);
        return this.result;
    }

        void  proceed(int row, int col, int profit) {

        if (row == heights.length-1 && row>=0  && col == heights[0].length-1 && col >= 0 && !memo[row][col]) {
            result = Math.min(profit, result);
            return;
        }

        memo[row][col] = true;
        if (col + 1 <= heights[0].length - 1 && !memo[row][col + 1]) {
            int effort = Math.abs(heights[row][col]- heights[row][col + 1]);
            int current = Math.max(effort, profit);
            if (result == Integer.MAX_VALUE || current < result) {
                proceed(row, col + 1, current);
            }
        }

        if (col-1 >= 0 && col-1 <= heights[0].length-1 && !memo[row][col-1]) {
            int effort = Math.abs(heights[row][col]- heights[row][col - 1]);

            int current = Math.max(effort, profit);
            if (result == Integer.MAX_VALUE || current < result) {
                proceed(row, col - 1, current);
            }
        }

        if (row-1 >= 0 && row-1 <= heights.length-1 && !memo[row-1][col]) {
            int effort = Math.abs(heights[row][col]- heights[row-1][col]);

            int current = Math.max(effort, profit);
            if (result == Integer.MAX_VALUE || current < result) {
                proceed(row - 1, col, current);
            }
        }

        if (row+1 <= heights.length-1 && !memo[row+1][col]) {
            int effort = Math.abs(heights[row][col]- heights[row+1][col]);

            int current = Math.max(effort, profit);
            if (result == Integer.MAX_VALUE || current < result) {
                proceed(row + 1, col, current);
            }
        }


        memo[row][col] = false;
    }
}
