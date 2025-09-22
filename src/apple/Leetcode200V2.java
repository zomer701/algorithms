package apple;

public class Leetcode200V2 {
    public static void main(String[] args) {
        char[][] grid = {
          {'1','1','1','1','0'},
          {'1','1','0','1','0'},
          {'1','1','0','0','0'},
          {'0','0','0','0','1'}
        };
        
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int result = 0;

        for (int col = 0; col < grid.length; col++) {
            for (int row = 0; row < grid[0].length; row++) {
                if (grid[col][row] == '1') {
                    dfs(col, row, grid);
                    result++;
                }
            }
        }

        return result;
    }

    private static void dfs(int col, int row, char[][] grid) {
        if (col < 0 || row < 0 || col >= grid.length || row >= grid[0].length || grid[col][row] == '0') {
            return;
        }

        grid[col][row] = '0';

        dfs(col-1, row, grid);

        dfs(col+1, row, grid);

        dfs(col, row-1, grid);

        dfs(col, row+1, grid);
    }
}
