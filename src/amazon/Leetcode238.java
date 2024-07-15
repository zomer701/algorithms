package amazon;

import java.util.Arrays;

public class Leetcode238 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
     Arrays.toString(productExceptSelf(nums));
    }
    public static int[] productExceptSelf(int[] nums){
        int length = nums.length;
        int[] L = new int[length];
        // Final answer array to be returned
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            // L[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            L[i] = nums[i - 1] * L[i - 1];
        }

        System.out.println(Arrays.toString(L));
        int[] R = new int[length];
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            // R[i + 1] already contains the product of elements to the right of 'i + 1'
            // Simply multiplying it with nums[i + 1] would give the product of all
            // elements to the right of index 'i'
            R[i] = nums[i + 1] * R[i + 1];
        }
        System.out.println(Arrays.toString(R));

        int[] answer = new int[length];
        // Constructing the answer array
        for (int i = 0; i < length; i++) {
            // For the first element, R[i] would be product except self
            // For the last element of the array, product except self would be L[i]
            // Else, multiple product of all elements to the left and to the right
            answer[i] = L[i] * R[i];
        }


        return answer;
    }
}
