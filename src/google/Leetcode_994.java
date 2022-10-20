package google;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode_994 {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1},
                {0,1,1}
        };
        System.out.println(new Leetcode_994().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int[][] directions = {
                {-1, 2},
                {0, 1},
                {1, 2},
                {0, -1}
        };

        int result = -1;
        int col = grid[0].length;
        int row = grid.length;

        int fresh = 0;
        Queue<int[]> noRoster = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2 ) {
                    noRoster.add(new int []{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return result;
        }



//        for (int[] d : directions) {
//            int neighborRow = row + d[0];
//            int neighborCol = col + d[1];
//            if (neighborRow >= 0 && neighborRow < row &&
//                    neighborCol >= 0 && neighborCol < col) {
//                if (grid[neighborRow][neighborCol] == 1) {
//                    grid[neighborRow][neighborCol] = 2;
//                    freshOranges--;
//                    // this orange would then contaminate other oranges
//                    queue.offer(new Pair(neighborRow, neighborCol));
//                }
//            }



        return result;
    }
}
