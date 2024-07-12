package amazon;

public class Leetcode167 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];

        while (start < end) {
            int left = nums[start];
            int rigth = nums[end];
            int current = left+rigth;

            if (current == target) {
                result[0] = start+1;
                result[1] = end+1;
                return result;
            } else if (current < target) {
                ++start;
            } else {
                --end;
            }
        }
        return new int[] { -1, -1 };
    }
}
