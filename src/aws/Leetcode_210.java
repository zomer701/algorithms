package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Leetcode_210 {

    public static void main(String[] args) {
        int numCourses = 2;
        //int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[][] prerequisites = new int[][]{{}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//
//        Queue<Integer> queue = new LinkedList<>();
//        Map<Integer, List<Integer>> graf = new HashMap<>();
//        int[] result = new int[numCourses];
//        int[] indegree = new int[numCourses];
//
//        for (int[] items: prerequisites) {
//            int to = items[0];
//            int from = items[1];
//
//            indegree[to]++;
//            graf.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
//        }
//
//        for (int start:indegree) {
//            if (start==0) {
//                queue.add(0);
//            }
//        }
//
//        int index=0;
//        while (!queue.isEmpty()) {
//            int course = queue.remove();
//            result[index++] = course;
//
//            for (Integer data: graf.getOrDefault(course, new ArrayList<>())) {
//                indegree[data]--;
//                if (indegree[data] == 0) {
//                    queue.add(data);
//                }
//            }
//
//        }
//
//        if (index == numCourses) {
//            return result;
//        }
//        return new int[0];
//    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);

            // Record in-degree of each vertex
            indegree[dest] += 1;
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;

            // Reduce the in-degree of each neighbor by 1
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;

                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }
}
