package craking.ArraysAndStrings;

import java.util.Arrays;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,1,3,6};
       System.out.println(new ContainsDuplicate().containsDuplicate(data));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }

        return false;
    }
}
