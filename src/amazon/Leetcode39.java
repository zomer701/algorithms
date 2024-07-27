package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Leetcode39 {
    public static void main(String[] args) {
        int [] candidates = {2,3,5};
        int target = 8;

        for (List<Integer> proceedItem: combinationSum(candidates, target)) {
            System.out.println(proceedItem);
        }
    }

    static Set<List<Integer>> result2 = new HashSet<>();
    static Set<Integer> memo = new HashSet<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, new LinkedList<>());
        return new ArrayList<>(result2);
    }

    private static void combinationSum(int[] candidates, int target, LinkedList<Integer> es) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            Collections.sort(es);
            result2.add(es);
            return;
        }

        for (int candidate: candidates) {
            LinkedList<Integer> newProceed = new LinkedList<>(es);
            newProceed.add(candidate);
            int value = target-candidate;
            combinationSum(candidates, value, newProceed);

        }

        memo.add(target);
    }
}
