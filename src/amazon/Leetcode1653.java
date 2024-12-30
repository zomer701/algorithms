package amazon;

import java.util.Stack;

public class Leetcode1653 {
    public static void main(String[] args) {
        System.out.print(minimumDeletions("aababbab"));
    }

    public static int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0 ; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == 'a' && stack.peek() == 'b') {
                stack.pop();
                count++;
            } else {
                stack.add(s.charAt(i));
            }


        }

        return count;
    }
}
