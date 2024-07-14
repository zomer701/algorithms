package amazon;

import java.util.HashMap;

public class Leetcode205 {
    public static void main(String[] args) {
        System.out.print(isIsomorphic("badc", "baba"));
    }

    //"paper"
    //        "title"


    // "badc"
   // "baba"

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> memo = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (memo.containsKey(s.charAt(i))) {
                if ((memo.get(s.charAt(i)) != t.charAt(i))) {
                    return false;
                }
            } else {
                if (memo.containsValue(t.charAt(i))) {
                    return false;
                }
                memo.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}
