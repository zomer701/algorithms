package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode_452 {
    public static void main(String[] args) {
        int data [][] = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(new Leetcode_452().findMinArrowShots(data));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

       int result = 1;

        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];

            if (firstEnd < xStart) {
                result++;
                firstEnd = xEnd;
            }

        }
       return result;
    }
}
