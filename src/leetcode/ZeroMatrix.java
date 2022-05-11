package leetcode;

import java.util.Arrays;

public class ZeroMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
//                {1,1,1},
//                {1,0,1},
//                {1,1,1}
        };

        new ZeroMatrix().setZeros(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i =0; i<row.length; i++) {
            if (row[i]) {
                for (int j = 0;j<matrix[0].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i =0; i<column.length; i++) {
            if (column[i]) {
                for (int j = 0;j<matrix.length;j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
