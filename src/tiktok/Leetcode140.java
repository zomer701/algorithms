package tiktok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leetcode140 {
    public static void main(String[] args) {

    }

    public  List<String> wordBreak(String s, List<String> wordDict) {

        Map<String, List<String>> memo = new HashMap<>();

        return wordBreak(s,  wordDict, memo);
    }

    private List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> memo) {
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

                List<String> data = wordBreak(suffix, wordDict, memo);
                List<String> pathResult = data.stream().map(i -> word +  (i.isEmpty() ? "" : " ") + i)
                        .collect(Collectors.toList());
                result.addAll(pathResult);
            }
        }

        memo.put(s, result);
        return result;
    }

}
