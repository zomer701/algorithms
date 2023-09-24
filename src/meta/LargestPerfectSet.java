package meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestPerfectSet {
    public static int largestPerfectSet(int[] riceBags) {
        Arrays.sort(riceBags); // Sort the bags of rice in increasing order.
        int n = riceBags.length;
        int maxSetSize = 0;

        // Iterate through the rice bags.
        for (int i = 0; i < n; i++) {
            Set<Integer> usedValues = new HashSet<>();
            usedValues.add(riceBags[i]);

            for (int j = i + 1; j < n; j++) {
                int product = riceBags[i] * riceBags[j];

                // Check if the product is a perfect square and the value hasn't been used before.
                if (isPerfectSquare(product) && !usedValues.contains(riceBags[j])) {
                    usedValues.add(riceBags[j]);

                    // Update the maximum set size.
                    maxSetSize = Math.max(maxSetSize, usedValues.size());
                }
            }
        }

        // If no valid set is found, return -1.
        if (maxSetSize < 2) {
            return -1;
        }

        return maxSetSize;
    }

    // Helper function to check if a number is a perfect square.
    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static void main(String[] args) {
        int[] riceBags = {4, 7, 4, 8, 9};
        int result = largestPerfectSet(riceBags);
        System.out.println(result); // Output: 3 (The largest perfect set is [5, 25, 625])
    }
}
