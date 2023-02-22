package aws;

public class Leetcode_540 {

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};

        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            if (nums[0] != nums[1]) {
                return nums[0];
            }

            return -1;
        }

        int mid = nums.length/2;
        for (int i = 0, j = nums.length-1; i <= mid; i=i+2,j=j-2 ) {

            if (nums[i] != nums[i+1]) {
                return nums[i];
            }

            if (nums[j] != nums[j-1]) {
                return nums[j];
            }
        }

        return -1;
    }
}
