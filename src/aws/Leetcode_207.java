package aws;

import java.util.*;

public class Leetcode_207 {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        System.out.println(new Leetcode_207().canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> [] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }


        int[] indegree = new int[numCourses];
        Arrays.sort(indegree);
        for (int[]e: prerequisites) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> nums = new LinkedList<>();
        for (int i=0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                nums.add(i);
            }
        }

        while (!nums.isEmpty()) {
            int current = nums.poll();
            for (int c: graph[current]) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    nums.add(c);
                }
            }
            numCourses--;
        }

        return numCourses==0;
    }
}
