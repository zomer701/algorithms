package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] data = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println(new EvaluateReversePolishNotation().evalRPN(data));
    }

    public int evalRPN(String[] tokens) {

            Stack<Integer> data = new Stack<>();

            for (String val: tokens) {
                if (!"+-*/".contains(val)) {
                    data.push(Integer.valueOf(val));
                    continue;
                }
                int i = 0;
                int second = data.pop();
                int first  = data.pop();
                if (val.charAt(0) == '+') {
                    i = first + second;
                }

                if (val.charAt(0) == '-') {
                    i = first - second;
                }

                if (val.charAt(0) == '*') {
                    i = first * second;
                }

                if (val.charAt(0) == '/') {
                    i = first / second ;
                }

                data.push(i);

            }

            return data.pop();
        }
    }
