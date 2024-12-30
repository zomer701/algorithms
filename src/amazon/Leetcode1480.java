package amazon;

public class Leetcode1480 {
    public int[] runningSum(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }


        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }

        return nums;
    }
}
