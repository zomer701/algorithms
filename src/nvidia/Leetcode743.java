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

        Set<Integer> used = new HashSet<>();
        int result = 0;

        while (!queue.isEmpty() && used.size() < n) {
            int[] current = queue.poll();
            int w = current[0];
            int s = current[1];

            if (used.contains(s)) {
                continue;
            }

            result = w;
            used.add(s);

            for (int[] edge : timeGraph.getOrDefault(s, Collections.emptyList())) {
                int next = edge[0];
                int wedge = edge[1];
                if (!used.contains(next)) {
                    queue.offer(new int[]{wedge + w, next});
                }
            }
        }

        return used.size() == n ? result : - 1;
    }
}
