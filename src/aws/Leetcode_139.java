package aws;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_139 {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");

        System.out.println(new Leetcode_139().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
