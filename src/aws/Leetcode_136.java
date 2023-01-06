package aws;

import java.util.Arrays;

public class Leetcode_136 {
    public static void main(String[] args) {
        int [] data = {4,1,2,1,2};
        System.out.println(new Leetcode_136().singleNumber(data));
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 != 0 && nums[i-1] != nums[i]) {
                return nums[i-1];
            }

            if (i == nums.length -1 && i % 2 == 0) {
                return nums[i];
            }
        }

        return -1;
    }
}
