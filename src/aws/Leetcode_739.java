package aws;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class Leetcode_739 {
    public static void main(String[] args) {
        int[] data = {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(new Leetcode_739().dailyTemperatures(data)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int [] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0;i < temperatures.length; i++) {
            int currentDay = temperatures[i];

            while (!stack.isEmpty() && currentDay > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay;
            }

            stack.push(i);
        }

        return answer;
    }
}
