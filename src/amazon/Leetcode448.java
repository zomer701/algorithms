package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Leetcode448 {
    public static void main(String[] args) {
        int [] data = {4,3,2,7,8,2,3,1};
        System.out.print(List.of(findDisappearedNumbers(data)));
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {

        // Hash table for keeping track of the numbers in the array
        // Note that we can also use a set here since we are not
        // really concerned with the frequency of numbers.
        HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();

        // Add each of the numbers to the hash table
        for (int i = 0; i < nums.length; i++) {
            hashTable.put(nums[i], true);
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<>();

        // Iterate over the numbers from 1 to N and add all those
        // that don't appear in the hash table.
        for (int i = 1; i <= nums.length; i++) {
            if (!hashTable.containsKey(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
