package nvidia;

public class Leetcode200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    result++;
                    landIsland(row, col, grid);
                }
            }
        }
        return result;
    }

    private static void landIsland(int row, int col, char[][] grid) {
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        landIsland(row-1, col, grid);
        landIsland(row+1, col, grid);
        landIsland(row, col-1, grid);
        landIsland(row, col+1, grid);
    }
}
