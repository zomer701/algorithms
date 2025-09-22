package apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode253 {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Min-heap of end times
        PriorityQueue<Integer> minEnd = new PriorityQueue<>();

        for (int[] iv : intervals) {
            int start = iv[0], end = iv[1];

            // If the earliest room frees up, reuse it
            if (!minEnd.isEmpty() && minEnd.peek() <= start) {
                minEnd.poll();
            }
            // Allocate (or reuse) a room until 'end'
            minEnd.offer(end);
        }

        // Heap size = number of rooms needed
        return minEnd.size();
    }

    private static int tests = 0, failed = 0;

    private static void checkInt(int actual, int expected, String name) {
        tests++;
        if (actual == expected) {
            System.out.println("✔ " + name + " => " + actual);
        } else {
            failed++;
            System.out.println("✘ " + name + " (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        // Basic cases
        checkInt(Leetcode253.minMeetingRooms(new int[][] { {0,30},{5,10},{15,20} }), 2, "Overlap needs 2 rooms");
        checkInt(Leetcode253.minMeetingRooms(new int[][] { {7,10},{2,4} }),          1, "Non-overlap needs 1");
        checkInt(Leetcode253.minMeetingRooms(new int[][] { {0,10},{10,20} }),        1, "Touching is OK (1 room)");

        // Edge cases
        checkInt(Leetcode253.minMeetingRooms(new int[][] {}),                        0, "Empty => 0 rooms");
        checkInt(Leetcode253.minMeetingRooms(new int[][] { {3,7} }),                 1, "Single meeting => 1 room");
        checkInt(Leetcode253.minMeetingRooms(new int[][] { {1,5},{1,5},{1,5} }),     3, "All overlap => 3 rooms");
        checkInt(Leetcode253.minMeetingRooms(new int[][] { {10,10},{10,10} }),       1, "Zero-length meetings");

        // Harder overlap pattern (max concurrency 3)
        checkInt(Leetcode253.minMeetingRooms(new int[][] { {1,5},{2,6},{4,8},{9,10} }), 3, "Staggered overlaps");


        System.out.println("\nSummary: " + (tests - failed) + " passed, " + failed + " failed, out of " + tests);
        if (failed > 0) System.exit(1);
    }
}
