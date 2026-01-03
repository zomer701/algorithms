package nvidia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Leetcode207v2 {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}}));
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] edges = new int [numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int needDoneCourse = prerequisite[1];
            graph.computeIfAbsent(needDoneCourse, k -> new ArrayList<>()).add(course);
            edges[course]++;
        }

        int result = 0;

        Queue<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (edges[i] == 0) {
                result++;
                deque.add(i);
            }
        }

        while (!deque.isEmpty()) {
            int processEdge = deque.poll();
            List<Integer> processEdges = graph.getOrDefault(processEdge, Collections.emptyList());

            for (int edge: processEdges) {
                edges[edge]--;
                if (edges[edge] == 0) {
                    result++;
                    deque.add(edge);
                }
            }
        }

        return result == numCourses;

    }
}
