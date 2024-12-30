package netflix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumPossible {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,1},
                          {0,0,0},
                          {0,0,0}};
        System.out.println(countPath(matrix));
    }


    public static int countPath(int[][] matrix) {
        return move(matrix.length-1, matrix[0].length-1,0, 0, matrix, new HashMap<>());
    }

    private static int move(int xMatrix, int yMatrix, int x, int y, int[][] matrix, HashMap<String, Integer> memo) {
        if (memo.containsKey(x + "_" + y)) {
            return memo.get(x + "_" + y);
        }

        if (x == xMatrix && y == yMatrix) {
            return 1;
        }

        int xMove = 0;
        if (x+1 <= xMatrix && matrix[x+1][y] == 0) {
            xMove = Math.max(move(xMatrix, yMatrix, x+1, y, matrix, memo), xMove);
            memo.put(x+1 + "_" + y, xMove);
        }

        int yMove = 0;
        if (y+1 <= yMatrix && matrix[x][y+1] == 0) {
            yMove = Math.max(move(xMatrix, yMatrix, x, y+1, matrix, memo), yMove);
            memo.put(x + "_" + y+1, yMove);
        }


        memo.put(x + "_" + y, xMove+yMove);
        return xMove+yMove;
    }


    static int TEMP_MAX = Integer.MAX_VALUE;
    public static int getSmallerPatch(int number, List<Integer> numbers, Map<Integer, Integer> memo) {
        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        if (number == 0) {
            return 0;
        }

        int currentMax = TEMP_MAX;
        for (int num: numbers) {
            int current = number - num;

            if (current >= 0) {
                currentMax = Math.min(getSmallerPatch(current, numbers, memo), currentMax);
                memo.put(current, currentMax);
            }
        }


        int result = currentMax != TEMP_MAX ? currentMax + 1 : TEMP_MAX;
        memo.put(number, result);
        return result;
    }

    public static boolean canSum(int number, List<Integer> numbers, Map<Integer, Boolean> memo) {

        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        if (number == 0) {
            return true;
        }

        for (int num: numbers) {
            int currentSum = number-num;
            if (currentSum >= 0) {
                boolean currentResult = canSum(currentSum, numbers, memo);
                memo.put(currentSum, currentResult);
                if (currentResult) {
                    return true;
                }
            }
        }

        memo.put(number, false);
        return false;
    }
}
