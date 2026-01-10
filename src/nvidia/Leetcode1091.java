package nvidia;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1091 {
    public static void main(String[] args) {

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] DIRS = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1; // distance

        int step = 1; // current layer distance (start is 1)

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                if (r == n - 1 && c == n - 1) return step;

                for (int[] d : DIRS) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        q.offer(new int[]{nr, nc});
                        grid[nr][nc] = 1; // mark visited
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
