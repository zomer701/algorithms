package aws;

public class Leetcode_152 {

    public static void main(String[] args) {
        int [] data = {2,-5,-2,-4,3};
        System.out.println(maxProduct(data));
    }
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i<nums.length; i++) {
            int current = nums[i];
            int temp = Math.max(current, Math.max(max_so_far * current, min_so_far*current));
            min_so_far = Math.min(current, Math.min(max_so_far * current, min_so_far*current));
            max_so_far = temp;

            result = Math.max(result, max_so_far);
        }

        return result;
    }
}
