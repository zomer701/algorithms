package apple;

public class Leetcode53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max(0, currentSum) + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }


        return maxSum;
    }
}
