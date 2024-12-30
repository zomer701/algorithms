package aws;

import java.util.List;

public class Leetcode_2781 {
    public static void main(String[] args) {
        String word = "leetcode";
        List<String> forbidden = List.of("de","le","e");
        new Leetcode_2781().longestValidSubstring(word, forbidden);
    }


    void solution1() {
        String word = "leetcode";
        List<String> forbidden = List.of("de","le","e");
        int max = 0;
        for (int i = 0; i <= word.length(); i++) {
            for (int j = i+1; j <= word.length(); j++) {
                String key = word.substring(i, j);

                int temp = 0;
                boolean support = true;
                for (String fob: forbidden) {
                    if (!key.contains(fob)) {
                        temp = Math.max(key.length(), temp);
                    } else {
                        support = false;
                        break;
                    }
                }

                if (support) {
                    max = Math.max(max, temp);
                }

            }
        }
        System.out.println(max);
    }
    public void longestValidSubstring(String word, List<String> forbidden) {


    }
}
