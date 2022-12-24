package aws;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Leetcode_743 {

    public static void main(String[] args) {
        int data [][] =  {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(new Leetcode_743().networkDelayTime(data, 4, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> data = new HashMap<>();
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>
                (Comparator.comparing(Pair::getFirst));
        Set<Integer> visit = new HashSet<>();
        int result = 0;

        for (int[] time: times) {
            List<int[]> values = data.getOrDefault(time[0], new ArrayList<>());
            int[] dataValues = new int[2];
            dataValues[0]=time[1];
            dataValues[1]=time[2];
            values.add(dataValues);
            data.put(time[0], values);
        }

        minHeap.add(new Pair(0, k));

        while (!minHeap.isEmpty()) {
            Pair<Integer, Integer> pair = minHeap.poll();
            int weight = pair.getFirst();
            int node = pair.getSecond();

            if (visit.contains(node)) {
                continue;
            }

            visit.add(node);
            result = Math.max(result, weight);

            for (int[] neighbors: data.getOrDefault(node, new ArrayList<>())) {
                if (!visit.contains(neighbors[0])) {
                    minHeap.add(new Pair(weight + neighbors[1], neighbors[0]));
                }
            }
        }

        return visit.size() == n ? result : -1;
    }

    public class Pair<T, T1> {
        T val;
        T1 val2;

        public Pair(T val, T1 val2) {
            this.val = val;
            this.val2 = val2;
        }

        public T getFirst() {
            return val;
        }

        public T1 getSecond() {
            return val2;
        }
    }
}
