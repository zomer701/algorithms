package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServerBlocks {
    public static void main(String[] args) {
        int [][] data = {
                {1,0,0,0},
                {0,1,0,0},
                {0,1,1,0}
        };
        // result = 5
        System.out.println("data1 = " + new ServerBlocks().getServerCommunication(data));

//        int [][] data2 = {
//                {1,0,0,1}
//        };
//        // result = 2
//        System.out.println("data2 = " + new ServerBlocks().getServerCommunication(data2));
    }

    private int getServerCommunication(int [][] matrix) {
        if (matrix == null) {
            return 0;
        }

        int rowL = matrix.length;
        int colL = matrix[0].length;
        int result = 0;
        for (int row = 0; row < rowL; row++) {
            for (int col = 0; col < colL; col++) {
                if (matrix[row][col] != 1) {
                    continue;
                }

                List<String> list = new ArrayList<>();
                dsf(row, col, rowL, colL, matrix, list, true, true, true, true);
                if (list.size() > 1) {
                    result += list.size();
                }

            }
        }

        return result;
    }

    private void dsf(int row, int col, int rowL, int colL, int[][] matrix, List<String> list,
                     boolean left, boolean rigth, boolean up, boolean down) {
        if (row >= rowL || row < 0 || col >= colL || col < 0 || matrix[row][col] == -1) {
            return;
        }

        boolean move = matrix[row][col] == 1;
        if (move) {
            list.add("val");
        }


        matrix[row][col] = -1;

        if (move) {
            dsf(row + 1, col, rowL, colL, matrix, list, move, move, move, move);
            dsf(row, col + 1, rowL, colL, matrix, list, move, move, move, move);
            dsf(row - 1, col, rowL, colL, matrix, list, move, move, move, move);
            dsf(row, col - 1, rowL, colL, matrix, list, move, move, move, move);
            return;
        }

        if (left) {
            dsf(row - 1, col, rowL, colL, matrix, list, true, false, false, false);
            return;
        }

        if (rigth) {
            dsf(row + 1, col, rowL, colL, matrix, list, false, true, false, false);
            return;
        }

        if (up) {
            dsf(row , col + 1, rowL, colL, matrix, list, false, false, true, false);
            return;
        }

        if (down) {
            dsf(row , col - 1, rowL, colL, matrix, list, false, false, false, true);
            return;
        }

    }
}
