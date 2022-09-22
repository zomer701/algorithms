package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InternalScheduling {
    public static void main(String[] args) {
        int[][] interval = {
                {0,3},
                {0,15},
                {5,10},
                {7,12},
                {11,16},
                {12,14},
                {16,20},
        };

        List<int []> optimalSchedule  = schedule(interval);
    }

    private static List<int[]> schedule(int[][] intervals) {
        List<int[]> optInternalSet = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int lastFinishTime = Integer.MIN_VALUE;

        for (int[] interval: intervals) {
            int start = interval[0];
            if (start > lastFinishTime) {
                int end = interval[1];
                optInternalSet.add(interval);

                lastFinishTime = end;
            }
        }

        return optInternalSet;
    }
}
