package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leetcode140 {

    public static void main(String[] args) {
        Map<String, List<String>> memo = new HashMap<>();
        for (String val: wordBreak("catsanddog",  Arrays.asList("cat","cats","and","sand","dog"), memo)) {
            System.out.println(val);
        }
    }

//    Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//    Output: ["cats and dog","cat sand dog"]
//
    public static List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        if (s.isEmpty()) {
            List<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }

        List<String> result = new ArrayList<>();

        for (String word: wordDict) {
            if (s.startsWith(word)) {
                String suffix = s.substring(word.length(), s.length());
                List<String> values = wordBreak(suffix, wordDict, memo);
                List<String> pathResult = values.stream().map(i -> word + (i.isEmpty() ? "" : " ") + i)
                        .collect(Collectors.toList());
                result.addAll(pathResult);
            }
        }

        memo.put(s, result);
        return result;
    }
}
