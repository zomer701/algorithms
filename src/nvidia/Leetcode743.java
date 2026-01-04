package nvidia;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode743 {
    public static void main(String[] args) {

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, k});

        Map<Integer, List<int[]>> timeGraph = new HashMap<>(n);
        for (int[] time: times) {
            timeGraph.computeIfAbsent(time[0], l -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Set<Integer> memo = new HashSet<>();
        int result = 0;

        while (!queue.isEmpty() && memo.size() < n) {
            int[] cur = queue.poll();
            int dist = cur[0];
            int node = cur[1];

            if (memo.contains(node)) continue;

            memo.add(node);
            result = dist;

            for (int[] edge : timeGraph.getOrDefault(node, Collections.emptyList())) {
                int next = edge[0];
                int w = edge[1];
                if (!memo.contains(next)) {
                    queue.offer(new int[]{dist + w, next});
                }
            }
        }

        return memo.size() != n ? -1 : result;
    }
}
