package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Leetcode_140 {

    public static void main(String[] args) {
        String s = "a";
        List<String> wordDict = Arrays.asList(new String[]{"a"});
        System.out.println(new Leetcode_140().wordBreak(s, wordDict));
    }
    public  List<String> wordBreak(String s, List<String> wordDict) {
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < s.length();i++ ) {
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

        int i = dp.length-1 ;

        Set<Integer> visited = new HashSet<>();
        Stack<Pair<Integer, String>> process = new Stack<>();
        List<String> result = new ArrayList<>();
        while (i >= 0) {
            if (dp[i] != null) {
                for (String data: dp[i]) {
                    if (visited.contains(data)) {
                        continue;
                    }
                    process.add(new Pair<>(i-data.length(), data));
                }

                while (!process.isEmpty()) {
                    Pair pair = process.pop();
                    if ((Integer) pair.val >= 0 && dp[(Integer) pair.val] != null) {
                        List<String> items = dp[(Integer) pair.val];
                        if (items.isEmpty()) {
                            if (s.equals((""+pair.val2).replaceAll("\\s+", ""))) {
                                result.add(""+pair.val2);
                            }
                            continue;
                        }

                        for (String data: dp[(Integer) pair.val]) {
                            if (visited.contains(data)) {
                                continue;
                            }

                            String values = data + " " + pair.val2;
                            if (s.equals(values.replaceAll("\\s+", ""))) {
                                result.add(values);
                                continue;
                            }
                            process.add(new Pair<>((Integer) pair.val-data.length(), values));
                        }
                    }
                }

            }

            i--;
        }



        return result;

    }

    private class Pair<T, T1> {
        T val;
        T1 val2;

        public Pair(T val, T1 val2) {
            this.val = val;
            this.val2 = val2;
        }

        public T getFirst() {
            return val;
        }

        public T1 getSecond() {
            return val2;
        }
    }
}
