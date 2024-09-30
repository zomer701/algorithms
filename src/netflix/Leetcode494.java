package netflix;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode494 {
    public static void main(String[] args) {
        int [] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(new Leetcode494().findTargetSumWays(nums, target));
    }

    int result = 0;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }



        return result;
    }

    public void process(int value, int[] nums, int level, int[][] memo) {
        if (level == nums.length) {
            if (value == 0) {
                this.result++;
            }
            return;
        }

        process(value-nums[level], nums, level+1, memo);
        process(value+nums[level], nums, level+1, memo);
    }
}
