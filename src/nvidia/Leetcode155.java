package nvidia;

import java.util.Stack;

public class Leetcode155 {
    public static void main(String[] args) {

    }

    class MinStack {

        Stack<int[]> memo;

        public MinStack() {
            memo = new Stack<>();
        }

        public void push(int val) {
            if (memo.isEmpty()) {
                memo.push(new int[] {val, val});
                return;
            }

            int [] header = memo.peek();
            memo.push(new int[] {val, Math.min(val, header[1])});
        }

        public void pop() {
            memo.pop();
        }

        public int top() {
            return memo.peek()[0];
        }

        public int getMin() {
            return memo.peek()[1];
        }
    }
}
