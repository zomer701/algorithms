package amazon;

import java.util.HashMap;
import java.util.Map;

public class Leetcode63 {
    public static void main(String[] args) {
         int[][] data = {{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(uniquePathsWithObstacles(data));
    }

    static int result = 0;
    static Map<String, Integer> memo = new HashMap<>();

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        execute(0,0, obstacleGrid);
        return result;
    }

    private static int execute(int x, int y, int[][] obstacleGrid) {
        if (memo.containsKey(x + "-" + y)) {
            return memo.get(x + "-" + y);
        }

        if (x < 0 || y < 0 || x >= obstacleGrid.length ||  y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1) {
            return 0;
        }

        if (x == obstacleGrid.length-1 && y == obstacleGrid[0].length-1) {
            result++;
            return 1;
        }

        int currentValue = execute(x+1, y, obstacleGrid) + execute(x, y+1, obstacleGrid);
        memo.put(x + "-" + y, currentValue);
        return currentValue;
    }
}
