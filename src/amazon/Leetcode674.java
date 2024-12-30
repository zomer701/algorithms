package amazon;

public class Leetcode674 {
    public static void main(String[] args) {
        int [] nums ={1,3,5,4,7};
        System.out.print(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int lengthOfLCIS = 1;
        int count = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev < nums[i]) {
                count++;
            } else {
                lengthOfLCIS = Math.max(lengthOfLCIS, count);
                count = 1;
            }

            prev = nums[i];
        }


        return count > 1 ? Math.max(lengthOfLCIS, count) : lengthOfLCIS;
    }
}
