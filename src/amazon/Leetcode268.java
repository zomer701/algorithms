package amazon;

public class Leetcode268 {
    public static void main(String[] args) {
        int [] num  = {3, 0 ,1};
        System.out.print(missingNumber(num));
    }

    public static int missingNumber(int[] nums) {
        if (nums == null) {
            return 1;
        }
        int n = nums.length;
        if (n <= 1) {
            return 1;
        }

        int currentSum = 0;
        for (int val: nums) {
            currentSum+=val;
        }

        int expectSum = 0;
        for (int i = 0 ; i <= nums.length; i++) {
            expectSum+=i;
        }

        return expectSum - currentSum;
    }
}
