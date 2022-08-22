package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Leetcode_904 {
    public static void main(String[] args) {
        int[] data = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(data));
    }

    public static int totalFruit(int[] fruits) {
        if (fruits.length == 0) {
            return 0;
        }

        if (fruits.length == 1) {
            return fruits[0];
        }


        int total = 1;
        Map<Integer, Integer> data = new HashMap<>();

        int j = 0;
        int i = 0;

        while (j < fruits.length) {
            if (data.size() <= 2) {
                data.put(fruits[j], j++);
            }

            if (data.size() > 2) {
                int min = fruits.length-1;
                for (int val: data.values()) {
                    min = Math.min(min, val);
                }

                i = min + 1;
                data.remove(fruits[min]);
            }
            total = Math.max(total, j-i);
        }
        return total;
    }
}
