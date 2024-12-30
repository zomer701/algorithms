package amazon;

public class Leetcode896 {
    public static void main(String[] args) {
        int [] data = {1,2,2,3};

        System.out.print(isMonotonic(data));
    }

    public static boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        Boolean increasing = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                continue;
            }

            if (nums[i-1] > nums[i]) {
                if (increasing == null) {
                    increasing = false;
                }

                if (increasing) {
                    return false;
                }
            }

            if (nums[i-1] < nums[i]) {
                if (increasing == null) {
                    increasing = true;
                }

                if (!increasing) {
                    return false;
                }
            }
        }

        return true;
    }
}
