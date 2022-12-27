package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_49 {
    public static void main(String[] args) {
        String[] values = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new Leetcode_49().groupAnagrams(values));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> memo = new HashMap<>();

        for (String values: strs) {
            char[] valuerArray = values.toCharArray();
            Arrays.sort(valuerArray);

            String key = Arrays.toString(valuerArray);
            List<String> anagrams = memo.getOrDefault(key, new ArrayList<>());
            anagrams.add(values);
            memo.put(key, anagrams);
        }

        return new ArrayList<>(memo.values());
    }
}
