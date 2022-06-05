package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    List<List<Integer>> output = new LinkedList();

    public static void main(String[] args) {
        for (List<Integer> list: new Combinations().combine(4, 2)) {
            System.out.println();
            for (Integer val: list) {
                System.out.print(val);
                System.out.print(",");
            }
        }
    }


    public void backtrack(int n, int k, int first, LinkedList<Integer> curr) {
        if (curr.size() == k)
            output.add(new ArrayList<>(curr));

        for (int i = first; i < n + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(n,k,i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1, new LinkedList<Integer>());
        return output;
    }
}
