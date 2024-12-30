package amazon;

import java.util.Map;
import java.util.Stack;

public class Leetcode20 {
    public static void main(String[] args) {
        System.out.print(isValid("{[]}"));
    }

    private static Map<Character, Character> closed = Map.of(')','(' ,'}','{', ']','[');

    public static boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character strChar: s.toCharArray()) {
            if (closed.containsKey(strChar)) {
                if (stack.isEmpty() || closed.get(strChar) != stack.pop()) {
                return false;
                }
            } else {
                stack.add(strChar);
            }
        }


        return stack.isEmpty();
    }
}
