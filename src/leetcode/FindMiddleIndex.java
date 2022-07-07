package leetcode;

public class FindMiddleIndex {
    public static void main(String[] args) {
        int [] data = {2,3,-1,8,4};
        System.out.println(new FindMiddleIndex().findMiddleIndex(data));
    }

    public int findMiddleIndex(int[] nums) {
        int sum = 0;

        for (int num: nums) {
            sum+= num;
        }

        int leftSum = 0;
        int index = 0;
        for (int i = 0; i<nums.length; i++) {
            if (index!=0) {
                leftSum += nums[i-1];
            }

            if (sum - leftSum - nums[i] == leftSum) {
                return index;
            }

            index++;
        }

        return -1;
    }
}
