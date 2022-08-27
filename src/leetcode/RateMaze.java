package leetcode;


//2^n^2 time
//n^2 space
public class RateMaze {
    public static void main(String[] args) {
        int maze [][] = {
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1},
        };

        int n = maze.length;

        int [][] sol = new int [n][n];
        solve(maze, 0 , 0, sol, n);
    }

    private static boolean solve(int[][] maze, int x, int y, int[][] sol, int n) {
        if (x == n-1 && y == n-1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y, n)) {
            sol[x][y] = 1;

            if (solve(maze, x+1, y, sol, n)){
                return true;
            }

            if (solve(maze, x, y + 1, sol, n)){
                return true;
            }

            sol[x][y] = 0;
        }

        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1;
    }
}
