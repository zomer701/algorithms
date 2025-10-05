package apple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();

        backtrack(n, k, 1, new LinkedList<>(), output);
        return output;
    }

    private static void backtrack(int n, int k, int i, LinkedList<Integer> state, List<List<Integer>> output) {
        if (state.size() == k) {
            output.add(new ArrayList<>(state));
            return;
        }

        for (int start = i; start <= n; start++) {
            state.add(start);
            backtrack(n, k, start+1, state, output);
            state.removeLast();
        }

    }
}
