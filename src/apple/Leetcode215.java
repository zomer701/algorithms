package apple;

import java.util.PriorityQueue;

public class Leetcode215 {
    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

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
