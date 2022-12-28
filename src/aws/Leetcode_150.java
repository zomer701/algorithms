package aws;

import java.util.Stack;

public class Leetcode_150 {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> data = new Stack<>();

        for (String token: tokens) {
            if (!"+-*/".contains(token)) {
                data.push(Integer.valueOf(token));
                continue;
            }

            int first = data.pop();
            int second = data.pop();

            int result = 0;
            if (token.charAt(0) == '+') {
                result = first + second;
            }

            if (token.charAt(0) == '-') {
                result = second - first;
            }

            if (token.charAt(0) == '*') {
                result = first * second;
            }

            if (token.charAt(0) == '/') {
                result = second / first;
            }

            data.push(result);
        }

        return data.isEmpty() ? 0 : data.peek();

    }
}
