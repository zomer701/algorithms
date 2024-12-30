package amazon;

public class Leetcode74 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;  //start from last row and first column
        int col = 0;

        while(col<matrix[0].length && row>=0)
        {
            if(matrix[row][col]> target)
            {
                row--;
            }
            else if(matrix[row][col]<target)
            {
                col++;
            }
            else
            {
                return true;
            }
        }

        return false;
    }
}
