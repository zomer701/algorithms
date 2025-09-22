package apple;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode252 {
    private static int tests = 0, failed = 0;

    private static void check(boolean actual, boolean expected, String name) {
        tests++;
        if (actual == expected) {
            System.out.println("✔ " + name);
        } else {
            failed++;
            System.out.println("✘ " + name + "  (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        check(Leetcode252.canAttendMeetings(new int[][] { {0, 10}, {10, 20}, {25, 30} }), true,  "No overlap");
        check(Leetcode252.canAttendMeetings(new int[][] { {0, 10}, {5, 15}, {20, 25} }),  false, "Simple overlap");
        check(Leetcode252.canAttendMeetings(new int[][] { {30, 40}, {0, 10}, {10, 20} }), true,  "Unsorted input");
        check(Leetcode252.canAttendMeetings(new int[][] { {10, 10}, {10, 20} }),         true,  "Zero-length meeting OK");
        check(Leetcode252.canAttendMeetings(new int[][] {}),                              true,  "Empty input");
        check(Leetcode252.canAttendMeetings(new int[][] { {3, 7} }),                      true,  "Single interval");
        check(Leetcode252.canAttendMeetings(new int[][] { {0, 30}, {15, 25}, {35, 45} }), false, "Overlap in middle");

        System.out.println("\nSummary: " + (tests - failed) + " passed, " + failed + " failed, out of " + tests);
        if (failed > 0) System.exit(1); // non-zero exit on failure (useful for CI)
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return true;

        // Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            int endPrev = intervals[i][1];
            int startCurrent = intervals[i+1][0];
            if (endPrev > startCurrent) {
                return false;
            }
        }




        return true;
    }
}
