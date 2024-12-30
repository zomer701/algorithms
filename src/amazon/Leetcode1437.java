package amazon;

public class Leetcode1437 {
    public static void main(String[] args) {
        int[] data = {1,0,0,1,0,0,1};
        int va = 2;
        System.out.print(kLengthApart(data, va));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        // initialize the counter of zeros to k
        // to pass the first 1 in nums
        int count = k;

        for (int num : nums) {
            // if the current integer is 1
            if (num == 1) {
                // check that number of zeros in-between 1s
                // is greater than or equal to k
                if (count < k) {
                    return false;
                }
                // reinitialize counter
                count = 0;

                // if the current integer is 0
            } else {
                // increase the counter
                ++count;
            }
        }
        return true;
    }
}
