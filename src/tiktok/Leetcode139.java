package tiktok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");

        System.out.println(new Leetcode139().wordBreak(s, wordDict));
    }

    List<String> wordDict = new ArrayList<>();

    boolean result = false;

    public boolean wordBreak2(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        prefixExecution(s);
        return result;
    }

    private void prefixExecution(String s) {
        if (result) {
            return;
        }

        if (s.isEmpty()) {
            result = true;
            return;
        }

        for (String prefix: wordDict) {
            if (s.startsWith(prefix)) {
                prefixExecution(s.substring(prefix.length()));
            }
        }
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] tb = new boolean[s.length()+1];
        tb[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            if (tb[i]) {
                String procced = s.substring(i);

                for (String word : wordDict) {
                    if (procced.startsWith(word)) {
                        tb[i + word.length()] = true;
                    }
                }
            }
        }

        return tb[s.length()];
    }
}
