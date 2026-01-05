package nvidia;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

public class Leetcode56 {
    public static void main(String[] args) {

    }

    // [[1,3],[2,6],[8,10],[15,18]]

    // CURRENT END
    // START END
    // CURRENT END > START2 && CURRENT END > START3 -> MERGE INTERVALS + KEEP CURRENT END [START 1; CURRENT END]
    // CURRENT END > START2 && CURRENT END < START3 -> MERGE INTERVALS + UPDATE CURRENT END TO START 3 [START 1; START3]
    //
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] {intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {

            int[] top = stack.peek();

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart <= top[1]) {
                top[1] = Math.max(top[1], currentEnd);
            } else {
                // no overlap
                stack.push(new int[]{currentStart, currentEnd});
            }
        }

        int size = stack.size();
        int[][] result = new int[size][2];
        for (int i = size - 1; i >= 0; i--) {
            int[] stackData = stack.pop();
            result[i][0] = stackData[0];
            result[i][1] = stackData[1];
        }

        return result;
    }
}
