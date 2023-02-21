package aws;

public class Leetcode_221 {
    public static void main(String[] args) {

    }
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;


        int[][] dp = new int[row+1][col+1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                } else {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }


                }


            }
        }

        return ans * ans;
    }
}
