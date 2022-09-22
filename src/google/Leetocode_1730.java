package google;

import java.util.LinkedList;
import java.util.Queue;

public class Leetocode_1730 {

    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'X', 'O', 'X'},
                {'X', 'O', 'X', '#', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        };
    }

    public int getFood ( char[][] grid, int k){
        int[][] DIRS = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[]{i, j});
                    break;
                }
            }
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (grid[x][y] == '#') {
                    return step;
                }

                for (int[] dir : DIRS) {
                    int r = x + dir[0];
                    int c = y + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 'X' && !visited[r][c]) {
                        visited[r][c] = true;
                        queue.offer(new int[] { r, c });
                    }
                }
            }

            step++;

            if (step >= k) {
                return -1;
            }
        }

        return -1;
    }
}
