package aws;

public class Leetcode_162 {
    public static void main(String[] args) {
        int [] nums = {1,6,4};
        System.out.println(new Leetcode_162().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int length = nums.length -1;

        if (length < 1) {
            return -1;
        }

        int l = 0;
        int r = length;

        while (l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
