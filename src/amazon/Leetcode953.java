package amazon;

import java.util.HashMap;

public class Leetcode953 {

    // words more > 1
    // order == all alphabetic
    // lower case

    public static void main(String[] args) {
        String [] words = {"app","app", "apa"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.print(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        String prev = words[0];
        int index = 1;

        int orderIndex = 0;
        HashMap<Character, Integer> indexOrder = new HashMap<>();
        for (char val: order.toCharArray()) {
            indexOrder.put(val, orderIndex++);
        }

        while (index < words.length) {
            String current = words[index];

            if (!isLexicographically(prev, current, indexOrder)) {
                return false;
            }
            prev = current;
            index++;
        }

        return true;
    }

    private static boolean isLexicographically(String prev, String current, HashMap<Character, Integer> indexOrder) {

        for (int i = 0; i < Math.min(prev.length(), current.length()); i++) {
            if (prev.charAt(i) == current.charAt(i)) {
                continue;
            }

            if (indexOrder.get(prev.charAt(i)) < indexOrder.get(current.charAt(i))) {
                return true;
            } else {
                return false;
            }
        }

        return prev.length() <= current.length();
    }
}
