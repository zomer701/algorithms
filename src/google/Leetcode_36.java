package google;

public class Leetcode_36 {
    public static void main(String[] args) {
        char[][]  board =
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(new Leetcode_36().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] data = new int[10][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }

                int valueInt = value-'0';
                if (data[i][valueInt] == 1 || data[valueInt][j] == 1) {
                    return false;
                }

                data[i][valueInt] = 1;
                data[valueInt][j] = 1;
            }
        }

        return true;
    }
}
