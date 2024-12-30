package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode77 {
    public static void main(String[] args) {
        for (List<Integer> combination: new Leetcode77().combine(4, 2)) {
            System.out.println(combination);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();

        backtrack(n, k, 1, new LinkedList<>(), output);
        return output;
    }

    private void backtrack(int n, int k, int i, LinkedList<Integer> state, List<List<Integer>> output) {
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
