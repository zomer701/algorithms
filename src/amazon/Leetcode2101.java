package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Leetcode2101 {
    public static void main(String[] args) {
        int[][] data = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        System.out.println(maximumDetonation(data));
    }

    //AB = √(xb - xa)2 + (yb - ya)2
    public static int maximumDetonation(int[][] bombs) {

        if (bombs.length == 1) {
            return 1;
        }

        int dep = 0;

        Map<String, Set<String>> graph = new HashMap<>();

        for (int i = 0; i < bombs.length; i++) {
            int[] first  = bombs[i];

            for (int j = 1; j < bombs.length; j++) {
                int[] second  = bombs[j];
                double distance = Math.sqrt(Math.pow(first[0]-second[0], 2) + Math.pow(first[1]-second[1], 2));
                if (first[2] >= distance || second[2] >= distance) {
                    String secondKey = second[0] + "-" + second[1];

                    String firstKey = first[0] + "-" + first[1];
                    Set<String> fArray = graph.getOrDefault(firstKey, new HashSet<>());
                    if (!firstKey.equals(secondKey)) {
                        fArray.add(secondKey);
                    }
                    graph.put(firstKey, fArray);


                    Set<String> sArray = graph.getOrDefault(secondKey, new HashSet<>());
                    if (!firstKey.equals(secondKey)) {
                        sArray.add(firstKey);
                    }
                    graph.put(secondKey, sArray);

                }
            }
        }

        int result = 1;
        Set<String> memo = new HashSet<>();
        for (int[] bomb: bombs) {
            int x = bomb[0];
            int y = bomb[1];
            String key = x + "-" + y;
            if (memo.contains(key)) {
                continue;
            }
            memo.add(key);
            dep = 1;

            Queue<String> queue = new LinkedList<>();
            queue.add(key);
            while (!queue.isEmpty()) {

                Set<String> neightbords = graph.getOrDefault(queue.poll(), new HashSet());
                for (String nei: neightbords) {
                    if (memo.contains(nei)) {
                        continue;
                    }
                    memo.add(nei);
                    queue.add(nei);
                    dep++;
                }
            }

            result = Math.max(result, dep);
        }


        return result;
    }



    public int maximumDetonation2(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;

        // Build the graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int xi = bombs[i][0], yi = bombs[i][1], ri = bombs[i][2];
                int xj = bombs[j][0], yj = bombs[j][1];

                // Create a path from node i to node j, if bomb i detonates bomb j.
                if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i, graph));
        }

        return answer;
    }

    private int dfs(int i, Map<Integer, List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(i);
        visited.add(i);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int neib : graph.getOrDefault(cur, new ArrayList<>())) {
                if (!visited.contains(neib)) {
                    visited.add(neib);
                    stack.push(neib);
                }
            }
        }
        return visited.size();
    }
}
