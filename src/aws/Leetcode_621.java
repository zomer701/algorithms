package aws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_621 {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 0;
        System.out.println(new Leetcode_621().leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) return 0;

        // Prepare priority queue of Task count
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
        int[] counts = new int[26];
        for (char c : tasks) counts[c - 'A']++;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) pq.offer(counts[i]);
        }

        // process queue and count for each section, where k = n + 1 slots
        int count = 0;
        while (!pq.isEmpty()) {
            int k = n + 1; // slots in on section
            List<Integer> list = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Integer taskCount = pq.poll();
                if (taskCount-- > 1) list.add(taskCount);
                count++;
                k--;
            }

            pq.addAll(list); // add valid task count back to pq
            if (pq.isEmpty()) break;
            count += k; // if k > 0, the section are all filled with idle interval
        }
        return count;
    }
}
