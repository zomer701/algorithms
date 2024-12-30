package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode139 {
    public static void main(String[] args) {
        String data  = "leetcode";
        List<String> dataEntries = new ArrayList<>();
        dataEntries.add("leet");
        dataEntries.add("code");
        System.out.println(new Leetcode139().wordBreak(data, dataEntries));
    }
    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
      return  helper(s, wordDict);
    }

    private boolean helper(String s, List<String> wordDict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.isEmpty()) {
            return true;
        }


        for (String word: wordDict) {
            boolean index = s.startsWith(word);
            if (index) {
                if (helper(s.substring(word.length(),s.length()), wordDict)) {
                    memo.put(s.substring(word.length(),s.length()), true);
                    return true;
                }
            }
        }

        memo.put(s, false);
        return false;
    }
}
