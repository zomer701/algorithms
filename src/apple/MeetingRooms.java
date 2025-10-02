package apple;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public static void main(String[] args) {

    }

    boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1][1] > intervals[i][0]) return false;
        }

        return true;
    }
}
