import java.util.HashSet;

public class MaximumErasureValue {
    public static void main(String[] args) {
        int[] data = {5,2,1,2,5,2,1,2,5};
        System.out.println(new MaximumErasureValue().maximumUniqueSubarray(data));
    }

    public int maximumUniqueSubarray(int[] nums) {
        int fPoint = 0;
        int sPoint = 0;
        int end = nums.length-1;
        HashSet<Integer> memo = new HashSet<>();

        int currentSum = 0;
        int max = Integer.MIN_VALUE;

        while (sPoint <= end) {
            if (!memo.contains(nums[sPoint])) {
                currentSum = currentSum + nums[sPoint];
                max = Math.max(max, currentSum);
                memo.add(nums[sPoint]);
                ++sPoint;
            } else {
                currentSum = currentSum - nums[fPoint];
                memo.remove(nums[fPoint]);
                ++fPoint;
            }
        }

        return max;
    }
}
