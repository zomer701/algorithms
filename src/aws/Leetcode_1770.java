package aws;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode_1770 {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        int[] nums = {-5,-3,-3,-2,7,1}, multipliers = {-10,-5,3,4,6};
        System.out.println(maximumScore(nums, multipliers));
    }

    private static int help(int i, int[] multipliers, int[] nums, int s, int e) {
        if (i == multipliers.length) {
            return 0;
        }

        int option1 = multipliers[i]*nums[s]+help(i+1, multipliers, nums, s+1, e);
        int option2 = multipliers[i]*nums[e]+help(i+1, multipliers, nums, s, e-1);
        return Math.max(option1, option2);
    }

    public  static int maximumScore(int[] nums, int[] multipliers) {
        return help(0, multipliers, nums, 0, nums.length-1);
    }
}
