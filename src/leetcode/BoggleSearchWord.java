package leetcode;

import java.util.List;

public class BoggleSearchWord {
    public static List<String> dict = List.of("RAY", "BOOKS");

    public static void main(String[] args) {
        char boggle[][] = {
                {'T', 'Y', 'R', 'S'},
                {'N', 'U', 'A', 'K'},
                {'Z', 'F', 'E', 'O'},
                {'A', 'C', 'B', 'O'}
        };

        int visited[][] = new int[4][4];
        String str = "";

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                findWordValue(boggle, visited, i, j, str);
            }
        }
    }

    private static void findWordValue(char[][] boggle, int[][] visited, int i, int j, String str) {
        visited[i][j] = 1;
        str = str + boggle[i][j];

        if (dict.contains(str)) {
            System.out.println("str " + str);
        }

        for (int row = i-1; row <= i+1; row++) {
            for (int col = j-1; col <= j+1; col++) {
                if (isVisible(row, col, visited)) {
                    findWordValue(boggle, visited, row, col, str);
                }
            }
        }
        visited[i][j] = 0;
    }

    private static boolean isVisible(int row, int col, int[][] visited) {
        return row >= 0 && row < 4 && col >= 0 && col < 4 && visited[row][col] != 1;
    }
}
