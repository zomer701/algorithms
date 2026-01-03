package nvidia;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode210 {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        // init graph
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            int course = p[0], pre = p[1];
            graph[pre].add(course);
            indegree[course]++;
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) st.push(i);
        }

        int index = 0;
        while (!st.isEmpty()) {
            int current = st.pop();
            result[index++] = current;

            for (int next : graph[current]) {
                if (--indegree[next] == 0) {
                    st.push(next);
                }
            }
        }

        return index == numCourses ? result : new int[0];
    }
}
