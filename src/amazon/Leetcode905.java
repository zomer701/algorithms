package amazon;

import java.util.Arrays;

public class Leetcode905 {
    public static void main(String[] args) {
        int[]  nums = {3,1,2,4};
        System.out.print(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int oddIntegers=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                swap(oddIntegers++, i, nums);
            }
        }

        return nums;
    }

    static void swap(int j, int i, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
