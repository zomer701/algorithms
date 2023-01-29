package aws;

import java.util.Arrays;

public class Leetcode_905 {
    public static void main(String[] args) {
        int [] nums = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }
    public static int[] sortArrayByParity(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {

                int low = i - 1;
                while(low >= 0 && nums[low] % 2 != 0) {
                    swap(low--, i--, nums);
                }
            }
        }

        return nums;
    }

    static void  swap(int j, int i, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
