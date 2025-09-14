package apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Leetcode207 {

    public static void main(String[] args) {

    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];
            List<Integer> data  = graph.getOrDefault(start, new ArrayList<>());
            data.add(end);
            graph.put(start, data);
        }

        Set<Integer> memo = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!memo.contains(current)) {
               memo.add(current);

                for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                    if (!memo.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }


            } else {
                return false;
            }
        }

        return true;
    }
}
