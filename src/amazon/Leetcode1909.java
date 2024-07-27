package amazon;

public class Leetcode1909 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,5,7};
        //1,2,10,5,7
        //2,3,1,5,7
        System.out.println(canBeIncreasing(nums));
    }

    public static boolean canBeIncreasing(int[] nums) {
        boolean removed = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (removed) return false;
                removed = true;
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }

}
