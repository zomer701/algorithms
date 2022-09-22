package leetcode;

//time v^n^2
//space n^2
public class KnightTour {
    private static int[] rowP = {2,1,-1,-2,-2,-1,1,-2};
    private static int[] colP = {1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) {

        int [][] board = {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}
        };

        knigthTour(board, 0, 0, 0);
    }

    private static boolean knigthTour(int[][] board, int row, int col, int step) {
        if (step == 63) {
            return true;
        }

        for (int i = 0; i<rowP.length; i++) {
            int newRow = row + rowP[i];
            int newCol = col + colP[i];

            if (isValidMove(board, newRow, newCol)) {
                step++;
                board[newRow][newCol] = step;

                if (knigthTour(board, newRow, newCol, step)) {
                    return true;
                }

                step--;
                board[newRow][newCol] = 0;
            }
        }

        return false;
    }

    private static boolean isValidMove(int[][] board, int newRow, int newCol) {
        return  (newCol >= 0 && newCol < 8
                && newRow >= 0 && newRow < 8
                && board[newRow][newCol] == 0);
    }
}
