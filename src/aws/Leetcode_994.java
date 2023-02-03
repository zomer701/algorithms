package aws;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode_994 {
    public static void main(String[] args) {
        int [][] data = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(orangesRotting(data));
    }

    public static int orangesRotting(int[][] grid) {
        if (grid == null) {
            return -1;
        }

        int RATE_LIMIT = 4;
        int row = grid.length;
        int col = grid[0].length;

        int fresh = 0;
        Queue<int[]> keys = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]==1) {
                    fresh++;
                }

                if (grid[i][j]==2) {
                    keys.offer(new int[]{i, j});
                }
            }
        }

        if (fresh==0) {
            return 0;
        }

        int currentRate = -1;

        while (!keys.isEmpty()) {
            int length = keys.size();

            currentRate++;

            for (int i =0; i < length; i++) {

                int[] current = keys.poll();

                int currentRow = current[0];
                int currentCol = current[1];


                if (currentRow + 1 < row && grid[currentRow + 1][currentCol] == 1) {
                    grid[currentRow + 1][currentCol] = 2;
                    fresh--;
                    keys.offer(new int[]{currentRow + 1, currentCol});
                }

                if (currentRow - 1 >= 0 && grid[currentRow - 1][currentCol] == 1) {
                    grid[currentRow - 1][currentCol] = 2;
                    fresh--;
                    keys.offer(new int[]{currentRow - 1, currentCol});
                }

                if (currentCol + 1 < col && grid[currentRow][currentCol + 1] == 1) {
                    grid[currentRow][currentCol + 1] = 2;
                    fresh--;
                    keys.offer(new int[]{currentRow, currentCol + 1});
                }

                if (currentCol - 1 >= 0 && grid[currentRow][currentCol - 1] == 1) {
                    grid[currentRow][currentCol - 1] = 2;
                    fresh--;
                    keys.offer(new int[]{currentRow, currentCol - 1});
                }
            }


        }

        return fresh == 0 ? currentRate : -1;
    }
}
