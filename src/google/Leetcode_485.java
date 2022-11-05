package google;

public class Leetcode_485 {
    public static void main(String[] args) {
        int [] data = {1,0,1,1,0,1};

        System.out.println(new Leetcode_485().findMaxConsecutiveOnes(data));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = -1;

        if (nums == null || nums.length < 0) {
            return result;
        }


        if (nums.length == 1) {
            return nums[0];
        }

        int count = 0;
        for (int i = 0; i < nums.length ; i++) {
           if (nums[i] == 0) {
               result = Math.max(result, count);
               count = 0;
           } else {
               count++;
           }
        }

        return Math.max(result, count);
    }
}
