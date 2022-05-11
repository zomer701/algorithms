package leetcode;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        final int[][] matrix = {
                { 1, 2},
                { 4, 5}
        };


//        { 4, 1},
//        { 5, 2}

        new RotateImage().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix)
    {
        int N =  matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - j - 1];
                matrix[i][N - j - 1] = temp;
            }
        }
    }
}
