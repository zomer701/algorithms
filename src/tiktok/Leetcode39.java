package tiktok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode39 {
    public static void main(String[] args) {

        int [] candidates = {2,3};
        int target = 7;

        System.out.println(new Leetcode39().combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> comb = combinationSum2(candidates, target);
        Set<List<Integer>> combinationSum = new HashSet<>();
        for (List<Integer> cat: comb) {
            Collections.sort(cat);
            combinationSum.add(cat);
        }

        return new ArrayList<>(combinationSum);
    }



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (target == 0) {
            List<List<Integer>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }

        if (target < 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int candidate: candidates) {
            int prefix = target - candidate;
            List<List<Integer>> combination = combinationSum2(candidates, prefix);
            if (!combination.isEmpty()) {
                for (List<Integer> combinationProcess: combination) {
                    combinationProcess.add(candidate);
                    result.add(combinationProcess);
                }

            }
        }


        return result;

    }

    public List<List<String>> allConstruct(String value,  String[] candidates) {
        if (value.isEmpty()) {
            List<List<String>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());

            return empty;
        }

        List<List<String>> result = new ArrayList<>();
        for (String candidate: candidates) {
            if (value.startsWith(candidate)) {
                String suffix = value.substring(candidate.length());
                List<List<String>> suffixWay = allConstruct(suffix, candidates);

                if (!suffixWay.isEmpty()) {
                    for (List<String> data: suffixWay) {
                        data.add(candidate);
                        result.add(data);
                    }
                }



            }
        }

        return result;
    }

    public List<Integer> canSum3(int[] candidates, int target, HashMap<Integer, List<Integer>> memo) {
        if (target < 0) {
            return null;
        }

        if (target == 0) {
            return new ArrayList<>();
        }

        List<Integer> shorter = null;

        for (int candidate: candidates) {
            int result = target - candidate;
            List<Integer> val = canSum3(candidates, result, memo);
            if (val != null) {
                val.add(candidate);

                if (shorter == null || val.size() < shorter.size()) {
                    shorter = val;
                }

            }
        }

        return shorter;
    }

    public List<Integer> canSum2(int[] candidates, int target, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target == 0) {
            memo.put(target, new ArrayList<>());
            return memo.get(target);
        }

        if (target < 0) {
            memo.put(target, null);
            return null;
        }


        for (int candidate: candidates) {
            int sum = target - candidate;
            List<Integer> values = canSum2(candidates, sum, memo);
            if (values != null) {
                values.add(candidate);
                memo.put(target, values);
                return values;
            }
        }

        memo.put(target, null);
        return null;
    }


    public boolean canSum(int[] candidates, int target, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target < 0) {
            memo.put(target, false);
            return false;
        }

        if (target  == 0) {

            memo.put(target, true);
            return true;
        }


        for (int i = 0; i < candidates.length; i++) {

            boolean result = canSum(candidates, target-candidates[i], memo);
            memo.put(target, result);
            if (result) {
                return true;
            }
        }

        memo.put(target, false);
        return false;
    }

}
