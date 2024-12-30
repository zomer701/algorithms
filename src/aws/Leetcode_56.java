package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode_56 {
    public static void main(String[] args) {
        int[][] data = {{1,3},{2,6},{8,10},{15,18}};
        int[][]  result = mergeV2(data);
        for (int[] item:  result) {
            System.out.println(Arrays.toString(item));
        }
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length<= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> memo = new ArrayList<>();
        int[] temp = intervals[0];
        memo.add(temp);

        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                temp = intervals[i];
                memo.add(temp);
            }
        }

        int[][] newIntervals = new int[memo.size()][2];
        int i =0;
        for (int[] data: memo) {
            newIntervals[i++] = data;
        }

        return newIntervals;
    }

    public static int[][] mergeV2(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> memo = new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int []i:intervals){
            if(i[0]<=end){
                end=Math.max(end,i[1]);
            }else{
                memo.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        memo.add(new int[]{start,end});
        return memo.toArray(new int[0][]);
    }
}
