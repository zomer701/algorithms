package aws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode_39 {
    HashMap memo = new HashMap<String, LinkedList<Integer>>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, 0, target, new LinkedList<>());

        return result;
    }

    public void  combinationSum(int[] candidates, int index, int target, LinkedList<Integer> current) {

        if (target == 0) {
            ArrayList dada = new ArrayList<>(current);
            Collections.sort(dada);
            String s = (String) dada.stream().
                    map(Object::toString).collect(Collectors.joining(","));

            if (memo.get(s) == null) {
                memo.put(s, current);
                result.add(dada);
            }
        }

        for (int i = index; i < candidates.length; i++) {
            int candidate = target - candidates[i];
            if (candidate >= 0) {
                current.add(candidates[i]);
                combinationSum(candidates, index, candidate, current);
                current.removeLast();
            }
        }
    }
}
