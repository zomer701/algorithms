package amazon;

import java.util.Arrays;

public class Leetcode169 {
    public static void main(String[] args) {
        int[] data = {2,2,1,1,1,2,2};
        System.out.print(majorityElement(data));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int mag = nums.length/2;
        Arrays.sort(nums);
        int count = 0;

        int prev = nums[0];
        for (int i = 1 ; i < nums.length; i++) {
            if (prev == nums[i]) {
                count++;
                if (count >= mag) {
                    return nums[i];
                }
            } else {
                count=0;
            }
            prev =  nums[i];
        }

        return -1;
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }
}
