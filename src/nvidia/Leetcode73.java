package nvidia;

import java.util.HashSet;
import java.util.Set;

public class Leetcode73 {
    public static void setZeroes(int[][] matrix) {

        Set<Integer> rowMemo = new HashSet<>();
        Set<Integer> colMemo = new HashSet<>();


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rowMemo.add(row);
                    colMemo.add(col);
                }
            }
        }

        for (int row: rowMemo) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = 0;
            }
        }

        for (int col: colMemo) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }
    }
}
