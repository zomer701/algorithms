package aws;

public class Leetcode_74 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        int target = 3;

        System.out.println(new Leetcode_74().searchMatrix(matrix, target));
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
