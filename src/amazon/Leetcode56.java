package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    public static void main(String[] args) {
        int [][] interval =  new int [][] {{1,3},{2,6},{8,10},{15,18}};
        System.out.print(Arrays.toString(merge(interval)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (end >= currentStart) {
                end = Math.max(end, currentEnd);
            } else {
                result.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[0][]);
    }
}
