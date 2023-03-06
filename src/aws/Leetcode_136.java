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
        for (int i = 0; i < nums.length; i+=2) {
            if (i+1 < nums.length && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }

        if (nums.length % 2 != 0) {
            return nums[nums.length-1];
        }

        return -1;
    }
}
