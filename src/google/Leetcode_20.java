package google;

import java.util.Map;
import java.util.Stack;

public class Leetcode_20 {
    public static void main(String[] args) {
        System.out.println("isValid " + new Leetcode_20().isValid("){"));
    }

    public boolean isValid(String s) {


        Map<Character, Character> memo = Map.of('(', ')', '[', ']', '{', '}');

        Stack<Character> stackValues = new Stack<>();

        for (char value: s.toCharArray()) {
            if (!memo.containsKey(value)) {
                if (stackValues.isEmpty() || value != stackValues.pop()) {
                    return false;
                }
            } else {
                stackValues.push(memo.get(value));
            }
        }

        return stackValues.isEmpty();
    }
}
