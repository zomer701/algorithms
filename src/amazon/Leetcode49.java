package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode49 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        for (List<String> result: groupAnagrams(strs)) {
            System.out.print(result);
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> memo = new HashMap<>();
        for (String val: strs) {
            char[] charsVal = val.toCharArray();
            Arrays.sort(charsVal);
            List<String> memoValue = memo.getOrDefault(Arrays.toString(charsVal), new ArrayList<>());
            memoValue.add(val);
            memo.put(Arrays.toString(charsVal), memoValue);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key: memo.keySet()) {
            result.add(memo.get(key));
        }
        return result;
    }
}
