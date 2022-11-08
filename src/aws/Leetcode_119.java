package aws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_119 {
    private Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Leetcode_119().getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i <= rowIndex ; i++) {
                result.add(getNumber(rowIndex, i));
            }
        return result;
    }

    private Integer getNumber(int row, int col) {
        String key = row + "-" + col;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int computedVal =
                (row == 0 || col == 0 || row == col) ? 1 : getNumber(row - 1, col - 1) + getNumber(row - 1, col);

        cache.put(key, computedVal);

        return computedVal;
    }
}
