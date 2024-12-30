package netflix;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2501 {
    public static void main(String[] args) {
        //System.out.println(new Leetcode2501().longestSquareStreak());
    }

//    public int longestSquareStreak(int[] nums) {
//
//    }


    public static List<List<Integer>> findSubsequences(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsequences(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsequences(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        // Base case: reached the end of the array
        if (index == arr.length) {
            result.add(new ArrayList<>(current)); // Add the current subsequence to the result
            return;
        }

        // Include the current element
        current.add(arr[index]);
        generateSubsequences(arr, index + 1, current, result);

        // Backtrack: remove the last element added
        current.remove(current.size() - 1);

        // Exclude the current element
        generateSubsequences(arr, index + 1, current, result);
    }
}
