package leetcode;

//n! time
//n space
public class NQueen {
    public static void main(String[] args) {
        int [][] board = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
        };

        int n = board.length;
        if ( saveTheQueens(board, 0, n)) {
            for (int i=0; i< n; i++) {
                for (int j=0; j< n; j++) {
                    System.out.println(" " + board[i][j] + " ");
                }
                System.out.println(" ");
            }
        }
    }

    private static boolean saveTheQueens(int[][] board, int col, int n) {
        if (col>=n) {
            return true;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                if (saveTheQueens(board, col+1, n)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        int i, j;
        for (i =0; i< col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (i =row ,j = col; i>0 && j > 0; i--, j--) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (i =row ,j = col; i<n && j > 0; i++, j--) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        return true;
    }
}
