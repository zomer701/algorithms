package google;

import java.util.Arrays;

public class Leetcode_31 {
    public static void main(String[] args) {
        var test1 = new int[] {1,2,3};
        new Leetcode_31().nextPermutation(test1);
        System.out.println(Arrays.toString(test1));
    }

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        for(int i = nums.length-2; i >= 0; i--) {

            if (nums[i] < nums[i+1]) {
                int end = nums.length-1;
                while (nums[end] <= nums[i]) {
                    end--;
                }

                swap(nums, i, end);
                reverse(nums, i+1);

                return;
            }
        }

        reverse(nums, 0);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

