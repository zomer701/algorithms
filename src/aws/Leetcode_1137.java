package aws;

public class Leetcode_1137 {

    private int n = 38;
    public int[] nums = new int[n];

    public static void main(String[] args) {
        System.out.println(new Leetcode_1137().tribonacciDP(4));
    }

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return tribonacci(n - 3) + tribonacci(n - 1) + tribonacci(n-2);
    }

    public int tribonacciDP(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;

       for (int i = 3; i < n + 1 ; i++) {
           nums[i] = nums[i-1] +  nums[i-2] + nums[i-3];
       }

       return nums[n];
    }
}
