package amazon;

import java.util.LinkedHashMap;
import java.util.Map;

public class Leetcode387 {

    public static void main(String[] args) {

    }
    public int firstUniqChar(String s) {
        int result = -1;
        Map<Character, Integer> temp = new LinkedHashMap<>();
        for (Character val: s.toCharArray()) {
            temp.put(val, temp.getOrDefault(val, 0) + 1);
        }


        for (int i = 0; i < s.length(); i ++) {
            if (temp.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return result;
    }
}
