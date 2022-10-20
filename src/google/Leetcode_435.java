package google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

public class Leetcode_435 {
    public static void main(String[] args) {
        int data [][] = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(new Leetcode_435().findMinArrowShots(data));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int end = points[0][1], prev = 0, count = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[prev][1] > points[i][0]) {
                if (points[prev][1] > points[i][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }
}
