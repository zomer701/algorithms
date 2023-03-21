package leetcode;

import org.apache.commons.math3.stat.descriptive.rank.Max;

public class HouseRobber {
    public static void main(String[] args) {
        int [] nums = {2,7,9,3,1};

        System.out.println(new HouseRobber().rob(nums));
    }
    public static int rob(int[] nums) {
        int oneStepBackValue = Integer.MIN_VALUE;
        int twoStepBackValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int temp = oneStepBackValue;
            oneStepBackValue = Math.max(current + (twoStepBackValue == Integer.MIN_VALUE ?  0 : twoStepBackValue),
                   oneStepBackValue == Integer.MIN_VALUE ?  0 : oneStepBackValue);

            twoStepBackValue = temp;
        }

        return oneStepBackValue;
    }
}
