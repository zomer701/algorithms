package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CombinationSum {
    public static void main(String[] args) {
        int[] test = {2,3,6,7};

        List<List<Integer>> result = new ArrayList<>();
        HashMap memo = new HashMap<String, LinkedList<Integer>>();
        new CombinationSum().combinationSum(test, 0,7, result, new LinkedList<>(), memo);

        for (List<Integer> list: result) {
            System.out.println();
            for (Integer val: list) {
                System.out.print(val);
                System.out.print(",");
            }
        }
    }

    public void  combinationSum(int[] candidates, int index, int target, List<List<Integer>>  result, LinkedList<Integer> current, HashMap<String, LinkedList<Integer>> memo) {

        if (target == 0) {
            ArrayList dada = new ArrayList<>(current);
            Collections.sort(dada);
            String s = (String) dada.stream().map(Object::toString).collect(Collectors.joining(","));
            if (memo.get(s) == null) {
                memo.put(s, current);
                result.add(dada);
            }
        }

       for (int i = index; i < candidates.length; i++) {
                int candidate = target - candidates[i];
                if (candidate >= 0) {
                    current.add(candidates[i]);
                    combinationSum(candidates, index, candidate, result, current, memo);
                    current.removeLast();
                }
        }
    }
}

