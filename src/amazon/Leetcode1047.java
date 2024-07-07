package amazon;

import java.util.Stack;

public class Leetcode1047 {
    public static void main(String[] args) {
        System.out.print(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        if (s.length() <= 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();

        int i = 1;
        stack.add(s.charAt(0));
        while (i < s.length()) {
            char current = s.charAt(i);
            if (!stack.empty() && stack.peek() == current) {
                stack.pop();
            } else {
                stack.add(current);
            }

            i++;
        }

        StringBuilder builder = new StringBuilder();
        for (Character character: stack) {
            builder.append(character);
        }

        return builder.toString();
    }
}
