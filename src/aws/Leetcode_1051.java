package aws;

import java.util.Arrays;

public class Leetcode_1051 {
    public static void main(String[] args) {
        int[] heights = new int[] {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int [] notSort = new int [heights.length];
        for (int i=0; i<heights.length; i++) {
            notSort[i]=heights[i];
        }

        Arrays.sort(heights);

        int result = 0;
        for (int i=0; i<heights.length; i++) {
            if (notSort[i] != heights[i]) {
                result++;
            }
        }

        return result;
    }
}
