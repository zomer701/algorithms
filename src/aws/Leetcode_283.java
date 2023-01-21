package aws;

import java.util.Arrays;

public class Leetcode_283 {
    public static void main(String[] args) {
        int [] data = {0,1,0,3,12};
        new Leetcode_283().moveZeroes(data);
        System.out.println(Arrays.toString(data));
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length ;j ++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        for (int index  = i; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
}
