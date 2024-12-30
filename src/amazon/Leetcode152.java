package amazon;

public class Leetcode152 {
    public static void main(String[] args) {

    }

    //-1,2,3,-2,4

    //-4 2 6 -2 -4
    public static  int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int result = 0;
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int maxTEMP = Math.min(nums[i], Math.min(nums[i]*max, nums[i]*min));
            int minTEMP = Math.max(nums[i], Math.max(nums[i]*max, nums[i]*min));

            min = minTEMP;
            max = maxTEMP;
            result = Math.max(result, maxTEMP);
        }


        return result;
    }
}
