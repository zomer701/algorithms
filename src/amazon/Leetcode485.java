package amazon;

public class Leetcode485 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.print(findMaxConsecutiveOnes2(nums));
    }

    public static int findMaxConsecutiveOnes2(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) {
            return 1;
        }

        if (nums.length == 1 && nums[0] == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i] = nums[i] + nums[i-1];
            } else {
                max = Math.max(max, nums[i-1]);
                nums[i] = 0;
            }
        }

        return Math.max(max, nums[nums.length-1]);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
       int count = 0;
       int result = 0;
       int n = 0;
        while (n < nums.length) {
            if (nums[n] == 1) {
               while (n < nums.length && nums[n] == 1) {
                   count++;
                   n++;
               }
                result = Math.max(result, count);
               count = 0;
            } else {

                n++;
            }
       }

        return result;
    }
}
