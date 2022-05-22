package leetcode;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] data = {3,0,1};
        System.out.println(new MissingNumber().missingNumber(data));
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }



        for (int i=0;i<nums.length-1;i++) {
            if (nums[i]+1 != nums[i+1]) {
                return nums[i]+1;
            }
        }

        return -1;
    }
}
