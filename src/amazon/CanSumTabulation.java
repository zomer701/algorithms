package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CanSumTabulation {
    public static void main(String[] args) {
        for (ArrayList<Integer> data: bestCanSum(7, new int[] {5, 3, 4, 7})) {
            System.out.println(data);
        }
    }

    static List<ArrayList<Integer>> bestCanSum(int k, int[] data) {
        HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
        memo.put(0, new ArrayList<>());

        List<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            if (memo.get(i) != null) {
                for (int value: data) {
                    ArrayList<Integer> current = new ArrayList<>(memo.get(i));
                    current.add(value);

                    if (i+value == k) {
                        result.add(current);
                    } else {
                        memo.put(i+value, current);
                    }

                }
            }
        }

        return result;
    }
}
