package leetcode;

public class LargestNumberAtLeastTwiceOOthers {
    public static void main(String[] args) {
        int [] data = {1,0};
        System.out.println(new LargestNumberAtLeastTwiceOOthers().dominantIndex(data));
    }

    public int dominantIndex(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        Integer prevMax = 0;
        int index = 0;
        for (int i = 0; i<nums.length;i++) {
            if (nums[i] > max) {
                prevMax = max;
                max = nums[i];
                index = i;
            }  else if (nums[i] > prevMax) {
                prevMax = nums[i];
            }
        }

        return (max >= 2 * prevMax) ? index : -1;
    }
}
