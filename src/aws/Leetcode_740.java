package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode_740 {
    public static void main(String[] args) {
        int[] data = {2,2,3,3,3,4};
        System.out.println(new Leetcode_740().deleteAndEarn(data));
    }

    public Leetcode_740() {
    }

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
        }

        List<Integer> elements = new ArrayList<Integer>(points.keySet());
        Collections.sort(elements);

        int result = 0;

        // Base cases
        int twoBack = 0;
        int oneBack = points.get(elements.get(0));

        for (int i = 1; i < elements.size(); i++) {
            int currentElement = elements.get(i);
            int temp = oneBack;
            if (currentElement-1 == elements.get(i-1)) {
                oneBack = Math.max(oneBack , currentElement+twoBack);
            } else {
                oneBack += currentElement;
            }

            twoBack = temp;
        }

        return result;
    }
}
