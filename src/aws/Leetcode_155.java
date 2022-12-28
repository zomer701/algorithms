package aws;

import google.Pair;

import java.util.Stack;

public class Leetcode_155 {
    public static void main(String[] args) {

    }

    class MinStack {

        Stack<Pair<Integer,Integer>> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Pair<>(val, val));
                return;
            }

            int currentMin = stack.peek().getSecond();
            stack.push(new Pair<>(val, Math.min(currentMin, val)));
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().getFirst();
        }

        public int getMin() {
            return stack.peek().getSecond();
        }
    }
}
