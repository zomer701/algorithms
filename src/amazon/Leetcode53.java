package amazon;

public class Leetcode53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {

        int maxSubarray = nums[0];
        int maxCurrentSubArray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            maxCurrentSubArray = Math.max(num, num+maxCurrentSubArray);
            maxSubarray = Math.max(maxSubarray, maxCurrentSubArray);
        }


        return maxSubarray;
    }
}
