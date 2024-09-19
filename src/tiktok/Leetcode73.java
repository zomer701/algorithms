package tiktok;

public class Leetcode73 {

    public static void main(String[] args) {
        int[][] test =  {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(test);
        print2D(test);
    }

    public static void print2D(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("-");
        }
    }

    private static void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    row[r] = true;
                    column[c] = true;
                }
            }
        }

        for (int r = 0; r < column.length; r++) {
            if (column[r]) {
                for (int c = 0; c < matrix.length; c++) {
                    matrix[c][r] = 0;
                }
            }
        }

        for (int r = 0; r < row.length; r++) {
            if (row[r]) {
                for (int c = 0; c < matrix[0].length; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
