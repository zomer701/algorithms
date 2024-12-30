package tiktok;

import java.util.Arrays;

public class Leetcode189 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;
        new Leetcode189().rotate(nums, k);

    }

    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }

        k %= nums.length;

        revertArray(nums, 0, nums.length-1);
        revertArray(nums, 0, k-1);
        revertArray(nums, k, nums.length-1);
     }

    static void revertArray(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
