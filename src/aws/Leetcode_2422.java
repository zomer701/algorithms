package aws;

public class Leetcode_2422 {

    public static void main(String[] args) {
        System.out.println(new Leetcode_2422().minimumOperations(new int[]{1,2,3,4}));

    }
    public int minimumOperations(int[] nums) {
        if (nums.length <=1) {
            return 0;
        }

        int count = 0;
        int start = 0;
        int end = nums.length-1;

        int firstValue = nums[start];
        int lastValue = nums[end];

        while (start < end) {

            if (firstValue < lastValue) {
                firstValue+=nums[++start];
                count++;
                continue;
            }

            if (firstValue > lastValue) {
                lastValue+=nums[--end];
                count++;
                continue;
            }

            firstValue = nums[++start];
            lastValue = nums[--end];
        }

        return count;
    }
}
