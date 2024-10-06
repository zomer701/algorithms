package netflix;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode740 {

    public static void main(String[] args) {
        int [] data = {2,2,3,3,3,4};

        System.out.println(new Leetcode740().deleteAndEarn(data));
    }
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int value: nums) {
            memo.put(value, value+memo.getOrDefault(value, 0));
        }

        int prev1 = 0;
        int prev2 = 0;

        List<Integer> values =  memo.keySet().stream().sorted().collect(Collectors.toList());

        int count = 0;
        for (int key: values) {
            if (count > 0 && (values.get(count - 1) + 1) == values.get(count)) {
                int temp = prev2;
                prev2 = Math.max(memo.get(key) + prev1, prev2);
                prev1 = temp;
            } else {
                int temp = prev2;
                prev2 = memo.get(key) + temp;
                prev1 = temp;
            }

            count++;

        }

        return prev2;
    }

}
