package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode797 {
    List<List<Integer>> result = new ArrayList<>();
    int target;
    int[][] graph;

    public static void main(String[] args) {

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        target = graph.length-1;
        this.graph = graph;
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        backtracking(0, path);
        return result;
    }

    void backtracking(int value, LinkedList<Integer> paths) {
        if (value == target) {
            List<Integer> resultPath = new ArrayList<>(paths);
            result.add(resultPath);
            return;
        }

        for (int nextNode : this.graph[value]) {
            paths.add(nextNode);
            backtracking(nextNode, paths);
            paths.removeLast();
        }
    }
}
