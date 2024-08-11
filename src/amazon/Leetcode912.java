package amazon;

import java.util.Arrays;

public class Leetcode912 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        System.out.print(Arrays.toString(sortArray(nums)));
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        return sortArrayHelper(0, nums.length, nums);
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int [] afterMerge = new int[leftArray.length+rightArray.length];
        int leftCount = 0;
        int rightCount = 0;

        int afterMergeIndex = 0;

        while (leftCount < leftArray.length && rightCount < rightArray.length) {
            if (leftArray[leftCount] < rightArray[rightCount]) {
                afterMerge[afterMergeIndex++] = leftArray[leftCount++];
            } else {
                afterMerge[afterMergeIndex++] = rightArray[rightCount++];
            }
        }

        while (leftCount < leftArray.length) {
            afterMerge[afterMergeIndex++] = leftArray[leftCount++];
        }

        while (rightCount < rightArray.length) {
            afterMerge[afterMergeIndex++] = rightArray[rightCount++];
        }

        return afterMerge;
    }

    private static int[] sortArrayHelper(int left, int right, int[] nums) {
        if (right-left < 2) {
            int[] newArray = new int[right-left];
            int count = left;

            for (int i = 0; i < right-left; i++, count++) {
                newArray[i] = nums[count];
            }
            return newArray;
        }

        int mid = (right+left)/2;

        return  merge(sortArrayHelper(left, mid, nums), sortArrayHelper(mid, right, nums));
    }
}
