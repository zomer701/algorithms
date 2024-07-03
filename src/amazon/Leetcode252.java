package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode252 {
    public static void main(String[] args) {
        int[][] data = {{7,10},{2,4}};
        System.out.print(canAttendMeetings(data));
    }

    static boolean canAttendMeetings(int[][] intervals) {

        if (intervals.length <= 1) {
            return true;
        }

        List<int[]> listIntervals = new ArrayList<>();

        for (int[] interval: intervals) {
            listIntervals.add(interval);
        }

        Collections.sort(listIntervals, Comparator.comparing((int[] o) -> o[0]));

        int[] prev = listIntervals.get(0);

        for (int i = 1; i<listIntervals.size(); i++) {
            if (prev[1] > listIntervals.get(i)[0]) {
                return false;
            }

            prev = listIntervals.get(i);
        }

        return true;
    }
}
