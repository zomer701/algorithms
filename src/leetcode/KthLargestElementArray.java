package leetcode;

import java.util.Arrays;

public class KthLargestElementArray {
    public static void main(String[] args) {
        int[] data = new int[]{3,2,1,5,6,4};
        System.out.println(new KthLargestElementArray().findKthLargest(data, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length)
        {
            return -1;
        }

        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}
