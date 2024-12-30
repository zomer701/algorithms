package amazon;

import java.util.Stack;

public class Leetcode844 {
    public static void main(String[] args) {
        System.out.print(backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private static String build(String s) {
        char[] data = s.toCharArray();
        Stack<Character> temp = new Stack<>();

        for (char val: data) {
            if (val == '#' && !temp.empty()) {
                temp.pop();
            } else {
                if (val != '#') {
                    temp.add(val);
                }
            }
        }
        return temp.toString();
    }
}
