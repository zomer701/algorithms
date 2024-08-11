package amazon;

import google.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode787 {
    public static void main(String[] args) {
        int n = 4; int [][]flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}; int src = 0; int dst = 3; int k = 1;
        System.out.print(new Leetcode787().findCheapestPrice(n, flights, src, dst, k));
    }

    int min = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (n==1) {
            return -1;
        }

        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
        for (int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            List<Pair<Integer, Integer>> data = graph.getOrDefault(from, new ArrayList<>());
            data.add(new Pair<>(to, cost));
            graph.put(from, data);
        }

        HashSet<Integer> memo = new HashSet<>();

        execute(src, graph, memo,dst, 0, 0, k);

        return min;
    }

    private void execute(int src, Map<Integer, List<Pair<Integer, Integer>>> graph, Set<Integer> memo, int dst,int current, int deep, int k) {
        if (src == dst) {
            min = Math.min(current, min);
            return;
        }

        if (deep > k) {
            return;
        }

        memo.add(src);

        if (graph.containsKey(src)) {
            for (Pair<Integer, Integer> val : graph.get(src)) {
                if (memo.contains(val.getFirst())) {
                    continue;
                }

                execute(val.getFirst(), graph, memo, dst, current + val.getSecond(), ++deep, k);

            }
        }
    }
}
