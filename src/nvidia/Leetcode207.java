package nvidia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode207 {
    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> memoPrerequisites = new HashMap<>();
        for (int [] prerequisit: prerequisites) {
            int course = prerequisit[0];
            int needToCourse = prerequisit[1];

            memoPrerequisites.computeIfAbsent(needToCourse, k -> new ArrayList<>()).add(course);

        }

        int[] state = new int[numCourses]; // 0=unvisited,1=visiting,2=done

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && courseRun(i, memoPrerequisites, state)) return false;
        }

        return true;
    }

    static boolean courseRun(int course, Map<Integer, List<Integer>> memoPrerequisites, int[] state) {
        state[course] = 1;

        for (int v : memoPrerequisites.getOrDefault(course, Collections.emptyList())) {
            if (state[v] == 1) return true;
            if (state[v] == 0 && courseRun(v, memoPrerequisites, state)) return true;
        }

        state[course] = 2;
        return false;
    }
}
