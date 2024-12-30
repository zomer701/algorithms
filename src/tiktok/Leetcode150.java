package tiktok;

import java.util.Stack;

public class Leetcode150 {
    public static void main(String[] args) {
        String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new Leetcode150().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int number2 = stack.pop();
            int number1 = stack.pop();


            int result = command(number1, number2, token);
            stack.add(result);
        }

        return stack.pop();
    }

    private int command(int one, int second, String operation) {
        int command;

        switch (operation) {
            case "+":
                command = one + second;
                break;
            case "-":
                command = one - second;
                break;
            case "*":
                command = one * second;
                break;
            case "/":
                command = one / second;
                break;
            default:
                command = 0;
        }

        return command;
    }
}
