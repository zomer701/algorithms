package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode_253 {
    public static void main(String[] args) {
        int[][] data = {{13,15},{1,13},{6,9}};
        System.out.println(new Leetcode_253().minMeetingRooms(data));
    }
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> reverseTasks = new PriorityQueue<>();
        reverseTasks.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= reverseTasks.peek()) {
                reverseTasks.poll();
            }

            reverseTasks.add(intervals[i][1]);

        }
        return reverseTasks.size();

    }
}
