package aws;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_54 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;

        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (result.size() < rows*columns) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }

            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }

            if (up != down) {
                // Traverse from right to left.
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[down][col]);
                }
            }

            if (left != right) {
                // Traverse upwards.
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }


            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }
}
