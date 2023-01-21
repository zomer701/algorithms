package aws;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_904 {
    //4
    public static void main(String[] args) {
        int [] data = new int[] {1,2,1};
        System.out.println(new Leetcode_904().totalFruit(data));
    }

            public int totalFruit(int[] fruits) {
                int point1 = 0;
                int point2 = 0;

                int max = Integer.MIN_VALUE;

                Map<Integer, Integer> memo = new HashMap<>();
                while(point1 < fruits.length) {
                    int current = fruits[point1++];

                    memo.put(current, memo.getOrDefault(current, 0) + 1);

                    if (memo.size() < 2 || memo.size() == 2 && memo.containsKey(current)) {
                        max = Math.max(max, point1-point2);
                        continue;
                    }


                    while (memo.size() > 2) {
                        int end = fruits[point2++];
                        int count = memo.get(end) - 1;
                        if (count == 0) {
                            memo.remove(end);
                        } else {
                            memo.put(end, count);
                        }
                    }

                }

                return max==Integer.MIN_VALUE ? 0: max;
            }
}
