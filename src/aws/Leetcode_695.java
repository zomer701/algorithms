package aws;

public class Leetcode_695 {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(new Leetcode_695().maxAreaOfIsland(grid));
    }

    int result = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int island = dfs(i , j, grid);
                    result = Math.max(island, result);
                }
            }
        }

        return result;
    }

    private int dfs(int i, int j, int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;


        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1 ) {
            return 0;
        }

        grid[i][j] = 0;

        return 1 + dfs(i, j+1, grid) + dfs(i, j-1, grid) + dfs(i+1, j, grid) + dfs(i-1, j, grid);
    }
}
