package apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public static void main(String[] args) {

    }

    int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        if (intervals.length == 1) {
            return 1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[0];

            if (!queue.isEmpty() && queue.peek() <= current[0]) {
                queue.poll();
            }

            queue.offer(current[1]);
        }

        return queue.size();
    }
}
