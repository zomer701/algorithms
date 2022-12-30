package aws;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(new Leetcode_621().leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) return 0;
        if (n == 0) return tasks.length;
        int[] hash = new int[26];
        int max = 0;
        List<Integer> list = new ArrayList<Integer>();

        for (char i : tasks) {
            hash[i - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] > max) {
                max = hash[i];
                list.clear();
                list.add(i);
            }else if (hash[i] == max) {
                list.add(i);
            }
        }
        int numOfMax = list.size();
        return Math.max(tasks.length, (max - 1) * (n + 1) + numOfMax);
    }
}
