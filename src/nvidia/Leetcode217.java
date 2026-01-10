package nvidia;

import java.util.PriorityQueue;

public class Leetcode217 {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int num: nums) {
            if (queue.size() == k) {
                if (queue.peek() < num) {
                    queue.poll();
                    queue.add(num);
                }
            } else {
                queue.add(num);
            }
        }

        return queue.size() == k ? queue.peek() : 0;
    }
}
