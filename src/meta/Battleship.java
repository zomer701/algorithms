package meta;

public class Battleship {
    public static void main(String[] args) {
        int R = 2;
        int C = 3;
        int[][]G = {{0, 0, 1}, {1, 0, 1}};

        System.out.println(new Battleship().getHitProbability(R, C, G));
    }
    public double getHitProbability(int R, int C, int[][] G) {
        double count = 0;
        for (int row = 0; row < R; row++) {
            for (int column = 0; column < C; column++) {
                count += G[row][column];
            }
        }
        return count/(R*C);
    }
}
