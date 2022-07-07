package leetcode;

import java.util.Stack;

public class BackspaceCompare {
    public static void main(String[] args) {
        System.out.println(new BackspaceCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String s) {
        char[] data = s.toCharArray();
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i<data.length; i++) {

            if (data[i] == '#') {
                if (!temp.isEmpty()) {
                    temp.pop();
                }
            } else {
                temp.add(data[i]);
            }
        }

        return temp.toString();
    }
}
