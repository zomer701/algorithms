package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode207 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.print(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }

        if (prerequisites.length == 0) {
            return true;
        }

        HashMap<Integer, List<Integer>> memo = new HashMap<>();

        for (int[] item: prerequisites) {
            int course = item[0];
            int preCourse = item[1];

            List<Integer> preCourseList = memo.getOrDefault(course, new ArrayList<>());
            preCourseList.add(preCourse);
            memo.put(course, preCourseList);
        }

        Map<Integer, Boolean> finishedCourses = new HashMap<>();


        for (int i = 0; i < numCourses; i++) {
            if (!bfs(i, new HashSet<>(), memo, finishedCourses)) {
                return false;
            }
        }
        return true;

    }

    static boolean bfs(int course, Set<Integer> path, HashMap<Integer, List<Integer>> memo,  Map<Integer, Boolean> finishedCourses) {
        if (finishedCourses.containsKey(course)) {
            return true;
        }

        if (path.contains(course)) {
            return false;
        }

        if (!memo.containsKey(course)) {
            return true;
        }

        path.add(course);

        for (Integer pre: memo.get(course)) {
            boolean result = bfs(pre, path, memo,  finishedCourses);
            finishedCourses.put(pre, result);
            if (!result) {
                return false;
            }
        }

        finishedCourses.put(course, true);
        return true;
    }
}
