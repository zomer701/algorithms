package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class KnightMoves {

    public static void main(String[] args) {
        System.out.println(new KnightMoves().minKnightMoves(2,1));
    }
    public int minKnightMoves(int x, int y) {

            int yMod = Math.abs(y);
            int xMod = Math.abs(x);
            int xStep = 0;
            int yStep = 0;

            Set<String> memo = new HashSet<>();

            Queue<List<String>> queueValues = new LinkedList();
            List<String> first = new ArrayList<>();
            first.add(xStep+"_"+yStep);
            queueValues.add(first);

            int level = 0;
            while(!queueValues.isEmpty()) {
                    List<String> temp = new ArrayList<>();
                    for (String data: queueValues.poll()) {

                        if ((xMod + "_" + yMod).equals(data)) {
                            return level;
                        }

                        int tempX = Integer.parseInt(data.split("_")[0]);
                        int tempY = Integer.parseInt(data.split("_")[1]);


                        int x1Point = tempX + 2;
                        int y1Point = tempY + 1;
                        if (x1Point > -2 && y1Point > -2 && !memo.contains(x1Point + "_" + y1Point)) {
                            temp.add(x1Point + "_" + y1Point);
                            memo.add(x1Point + "_" + y1Point);
                        }

                        int x2Point = tempX + 1;
                        int y2Point = tempY + 2;
                        if (x2Point > -2 && y2Point > -2 && !memo.contains(x2Point + "_" + y2Point)) {
                            temp.add(x2Point + "_" + y2Point);
                            memo.add(x2Point + "_" + y2Point);
                        }

                        int x3Point = tempX - 1;
                        int y3Point = tempY + 2;
                        if (x3Point > -2 && y3Point > -2 && !memo.contains(x3Point + "_" + y3Point)) {
                            temp.add(x3Point + "_" + y3Point);
                            memo.add(x3Point + "_" + y3Point);
                        }

                        int x4Point = tempX - 2;
                        int y4Point = tempY + 1;
                        if (x4Point > -2 && y4Point > -2 && !memo.contains(x4Point + "_" + y4Point)) {
                            temp.add(x4Point + "_" + y4Point);
                            memo.add(x4Point + "_" + y4Point);
                        }

                        int x5Point = tempX - 2;
                        int y5Point = tempY - 1;
                        if (x5Point > -2 && y5Point > -2 && !memo.contains(x5Point + "_" + y5Point)) {
                            temp.add(x5Point + "_" + y5Point);
                            memo.add(x5Point + "_" + y5Point);
                        }

                        int x6Point = tempX - 1;
                        int y6Point = tempY - 2;
                        if (x6Point > -2 && y6Point > -2 && !memo.contains(x6Point + "_" + y6Point)) {
                            temp.add(x6Point + "_" + y6Point);
                            memo.add(x6Point + "_" + y6Point);
                        }

                        int x7Point = tempX + 1;
                        int y7Point = tempY - 2;
                        if (x7Point > -2 && y7Point > -2 && !memo.contains(x7Point + "_" + y7Point)) {
                            temp.add(x7Point + "_" + y7Point);
                            memo.add(x7Point + "_" + y7Point);
                        }

                        int x8Point = tempX + 2;
                        int y8Point = tempY - 1;
                        if (x8Point > -2 && y8Point > -2 && !memo.contains(x8Point + "_" + y8Point)) {
                            temp.add(x8Point + "_" + y8Point);
                            memo.add(x8Point + "_" + y8Point);
                        }
                    }
                    queueValues.add(temp);
                    level++;
                }
            return level;
    }
}
