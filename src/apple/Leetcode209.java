package apple;

public class Leetcode209 {
    public static void main(String[] args) {

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        long sum = 0L;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
