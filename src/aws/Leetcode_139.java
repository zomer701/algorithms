package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Leetcode_139 {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");

        System.out.println(new Leetcode_139().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();

        for(int i=0; i<s.length(); i++) {
            if (dp[i] == null)
                continue;
            for (String word : wordDict) {
                int len = word.length();
                int end = i + len;
                if (end > s.length())
                    continue;
                if(s.substring(i,end).equals(word)){
                    if(dp[end] == null){
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }


        return dp[s.length()] != null;
    }
}
