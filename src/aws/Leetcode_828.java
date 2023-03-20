package aws;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_828 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_828().uniqueLetterString("ABA"));
    }

    public int uniqueLetterString(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length(); j++) {
                var word = str.substring(i, j);
                int val = 0;

                Map<Character, Integer> memoProcess = new HashMap<>();
                var process = word.toCharArray();
                while (val < process.length) {
                    memoProcess.put(process[val], memoProcess.getOrDefault(process[val], 0) + 1);
                    val++;
                }

                for (Character key: memoProcess.keySet()) {
                    if (memoProcess.get(key) == 1) {
                        count ++;
                    }
                }

            }
        }

        return count;
    }
}
