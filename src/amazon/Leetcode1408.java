package amazon;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1408 {

    public static List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break; // Once we find a match, we can stop checking further
                }
            }
        }
        return res;
    }
}
