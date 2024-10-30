package adobe;

public class Leetcode300 {

    public static void main(String[] args) {
        int [] data = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(data));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int prev = nums[0];
        int count = 1;
        int result = 1;

        for (int i = 1; i < n; i++) {
            int current = nums[i];
            if (prev < current) {
                count++;
                result = Math.max(result, count);
            }  else {
                count = 1;
            }

            prev = current;
        }

        return result;
    }
}
