package meta;

import java.util.List;

public class Leetcode139 {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] tb = new boolean[s.length()+1];
        tb[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (tb[i]) {
                for (String word: wordDict) {
                    if (s.substring(i).startsWith(word)) {
                        tb[i+word.length()] = true;
                    }
                }
            }
        }

        return tb[s.length()];
    }
}
