package aws;

import java.util.Arrays;

public class Leetcode_128 {
    public static void main(String[] args) {
        int[] data = {1,2,0,1};
        System.out.println(new Leetcode_128().longestConsecutive(data));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }


        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);
        int result = 0;

        int init = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                continue;
            }

            if (nums[i]+1 == nums[i+1]) {
                init++;
            } else {
                result = Math.max(result, init);
                init = 1;
            }
        }

        return Math.max(result, init);
    }
}
